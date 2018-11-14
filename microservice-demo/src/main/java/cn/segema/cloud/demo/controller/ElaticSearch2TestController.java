package cn.segema.cloud.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.demo.vo.CarTransactionVO;

@RestController
@RequestMapping(value = "/elastic_search2/test")
public class ElaticSearch2TestController {

	private static String indexName = "car";

	private static String indexType = "transaction";

	@Autowired
	TransportClient transportClient;

	@PostMapping("/save")
	public ResponseEntity save(String id) {
		try {
			XContentBuilder content = XContentFactory.jsonBuilder()
					.startObject()
					.field("id", id)
					.field("price", 100)
					.field("color", "red")
					.field("sold", new Date())
					.endObject();

			IndexResponse result = this.transportClient.prepareIndex(indexName, indexType).setSource(content).get();
			return new ResponseEntity(result.getId(), HttpStatus.OK);

		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/saveAll")
	public String saveAll() {
		List<CarTransactionVO> list = new ArrayList<CarTransactionVO>();
		for (int i = 0; i < 10; i++) {
			CarTransactionVO carsTransactionsVO = new CarTransactionVO();
			carsTransactionsVO.setPrice(i);
			carsTransactionsVO.setColor("red" + i);
			carsTransactionsVO.setMake("HONDA" + i);
			carsTransactionsVO.setSold(new Date());
			list.add(carsTransactionsVO);
		}
	  BulkRequestBuilder bulkRequest = this.transportClient.prepareBulk();
        int count=0;
        while(count<list.size()){
            bulkRequest.add(this.transportClient.prepareIndex(indexName,indexType).setSource(list.get(count)));
            bulkRequest.execute().actionGet();
            count++;
        }
        bulkRequest.execute().actionGet();
		
		return "success";
	}

	@DeleteMapping("/delete")
	public ResponseEntity delete(String id) {
		DeleteResponse result = this.transportClient.prepareDelete(indexName, indexType, id).get();
		return new ResponseEntity(result.getResult().toString(), HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity update(String id, String color, String make) {
		UpdateResponse result;
		try {
			XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
			if (color != null) {
				builder.field("color", color);
			}
			if (make != null) {
				builder.field("make", make);
			}
			builder.endObject();
			UpdateRequest updateRequest = new UpdateRequest(indexName, indexType, id);
			updateRequest.doc(builder);

			result = this.transportClient.update(updateRequest).get();
			return new ResponseEntity(result.getResult().toString(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity("更新失败", HttpStatus.OK);
	}

	@GetMapping("/getOne")
	public ResponseEntity getOne(String id) {
		GetResponse result = this.transportClient.prepareGet(indexName, indexType, id).get();
		return new ResponseEntity(result.getSource().toString(), HttpStatus.OK);
	}

	@GetMapping("/getList")
	public ResponseEntity getList(String color, String make) {
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		if (color != null) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("color", color));
		}
		if (make != null) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("make", make));
		}

		// RangeQueryBuilder rangeQueryBuilder =
		// QueryBuilders.rangeQuery("price").from(15000).to(20000);
		// boolQueryBuilder.filter(rangeQueryBuilder);

		SearchRequestBuilder searchRequestBuilder = this.transportClient.prepareSearch(indexName).setTypes(indexType)
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(boolQueryBuilder).setFrom(0).setSize(100);
		System.out.println(searchRequestBuilder);

		SearchResponse response = searchRequestBuilder.get();
		List<Map<String, Object>> result = new ArrayList<>();
		for (SearchHit hit : response.getHits()) {
			result.add(hit.getSource());
		}

		return new ResponseEntity(result, HttpStatus.OK);
	}

	@GetMapping("/getStatistcs")
	public ResponseEntity getStatistcs() throws Exception {
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		// boolQueryBuilder.must(QueryBuilders.matchQuery("color", "red"));
		// boolQueryBuilder.must(QueryBuilders.matchQuery("make", "honda"));

		// RangeQueryBuilder rangeQueryBuilder =
		// QueryBuilders.rangeQuery("price").from(15000).to(20000);
		// boolQueryBuilder.filter(rangeQueryBuilder);

		//string类型的字段存进elasticsearch时，一个字符串字段有两个类型，一个text类型，分词类型；一个keyword类型，不分词类型；
		//所以加上.keyword就可以正常聚合了，对于es2.x版本有可能不分词的类型为.raw；
		AggregationBuilder termsBuilder = AggregationBuilders.terms("colorAgg").field("color.keyword").size(5);

		SearchRequestBuilder searchRequestBuilder = this.transportClient.prepareSearch(indexName).setTypes(indexType)
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(boolQueryBuilder).setFrom(0).setSize(100);
		searchRequestBuilder.addAggregation(termsBuilder);
		SearchResponse response = searchRequestBuilder.get();

		Terms terms = response.getAggregations().get("colorAgg");
		for (Terms.Bucket bucket : terms.getBuckets()) {
			StringBuilder builder = new StringBuilder();
			builder.append(bucket.getKey()).append(": ").append(bucket.getDocCount());
			System.out.println(builder);
		}

		List<Map<String, Object>> result = new ArrayList<>();
		for (Terms.Bucket bucket : terms.getBuckets()) {
			Map map = new HashMap();
			map.put(bucket.getKey(), bucket.getDocCount());
			result.add(map);
		}

		return new ResponseEntity(result, HttpStatus.OK);
	}

}
