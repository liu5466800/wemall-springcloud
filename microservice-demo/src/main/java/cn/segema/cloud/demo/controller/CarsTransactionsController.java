package cn.segema.cloud.demo.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.demo.repository.CarsTransactionsRepository;
import cn.segema.cloud.demo.vo.CarsTransactionsVO;

@RestController
@RequestMapping(value = "/cars/transactions")
public class CarsTransactionsController {

	private static String indexName = "cars";

	private static String indexType = "transactions";

	@Autowired
	private CarsTransactionsRepository carsTransactionsRepository;

	@Autowired
	TransportClient client;

	@PostMapping("/save")
	public ResponseEntity save(String id) {
		try {
			XContentBuilder content = XContentFactory.jsonBuilder().startObject()
					.field("id", id)
					.field("price", 100)
					.field("color", "red")
					.field("sold", new Date())
					.endObject();

			IndexResponse result = this.client.prepareIndex(indexName, indexType).setSource(content).get();
			return new ResponseEntity(result.getId(), HttpStatus.OK);

		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/saveAll")
	public String saveAll() {
		List<CarsTransactionsVO> list = new ArrayList<CarsTransactionsVO>();
		for (int i = 0; i < 10; i++) {
			CarsTransactionsVO carsTransactionsVO = new CarsTransactionsVO();
			carsTransactionsVO.setPrice(i);
			carsTransactionsVO.setColor("red" + i);
			carsTransactionsVO.setMake("HONDA" + i);
			carsTransactionsVO.setSold(LocalDateTime.now());
			list.add(carsTransactionsVO);
		}
		carsTransactionsRepository.saveAll(list);
		return "success";
	}

	@DeleteMapping("/delete")
	public ResponseEntity delete(String id) {
		DeleteResponse result = this.client.prepareDelete(indexName, indexType, id).get();
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

			result = this.client.update(updateRequest).get();
			return new ResponseEntity(result.getResult().toString(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity("更新失败", HttpStatus.OK);
	}

	@GetMapping("/getOne")
	public ResponseEntity getOne(String id) {
		GetResponse result = this.client.prepareGet(indexName, indexType,id).get();
		return new ResponseEntity(result.getSource().toString(), HttpStatus.OK);
	}

	@PostMapping("/getList")
	public ResponseEntity getList(String color, String make) {
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		if (color != null) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("color", color));
		}
		if (make != null) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("make", make));
		}

		// RangeQueryBuilder rangeQueryBuilder =
		// QueryBuilders.rangeQuery("price").from(2000);
		// if (price != null && price > 0)
		// {
		// rangeQueryBuilder.to(price);
		// }
		// boolQueryBuilder.filter(rangeQueryBuilder);

		SearchRequestBuilder searchRequestBuilder = this.client.prepareSearch(indexName).setTypes(indexType)
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(boolQueryBuilder).setFrom(0).setSize(100);
		System.out.println(searchRequestBuilder);

		SearchResponse response = searchRequestBuilder.get();
		List<Map<String, Object>> result = new ArrayList<>();
		for (SearchHit hit : response.getHits()) {
			result.add(hit.getSource());
		}

		return new ResponseEntity(result, HttpStatus.OK);
	}

}
