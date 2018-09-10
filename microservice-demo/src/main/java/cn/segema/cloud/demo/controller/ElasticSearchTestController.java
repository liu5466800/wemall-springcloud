package cn.segema.cloud.demo.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.demo.repository.CarsTransactionsRepository;
import cn.segema.cloud.demo.vo.CarsTransactionsVO;

@RestController
@RequestMapping(value = "/elastic_search/test")
public class ElasticSearchTestController {

	@Autowired
	private CarsTransactionsRepository carsTransactionsRepository;

	@GetMapping("/save")
	public ResponseEntity save(String id) {
		 CarsTransactionsVO carsTransactionsVO = new CarsTransactionsVO();
		 carsTransactionsVO.setId(id);
		 carsTransactionsVO.setPrice(123);
		 carsTransactionsVO.setColor("red");
		 carsTransactionsVO.setMake("HONDA");
		 carsTransactionsVO.setSold(LocalDateTime.now());
		 CarsTransactionsVO resultVO = carsTransactionsRepository.save(carsTransactionsVO);
		return  new ResponseEntity(resultVO, HttpStatus.OK);
	}

	@GetMapping("/saveAll")
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

	@GetMapping("/delete")
	public ResponseEntity delete(String id) {
		carsTransactionsRepository.deleteById(id);
		return new ResponseEntity("刪除成功", HttpStatus.OK);

	}

	@GetMapping("/update")
	public ResponseEntity update(String id, String color, String make) {
		 CarsTransactionsVO carsTransactionsVO = new CarsTransactionsVO();
		 carsTransactionsRepository.save(carsTransactionsVO);
		return new ResponseEntity("更新失败", HttpStatus.OK);
	}

	@GetMapping("/getOne")
	public ResponseEntity getOne(String id) {
		 Optional<CarsTransactionsVO> carsTransactionsVO = carsTransactionsRepository.findById(id);
		return new ResponseEntity(carsTransactionsVO, HttpStatus.OK);
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
		 // QueryBuilders.rangeQuery("price").from(2000);
		 // if (price != null && price > 0)
		 // {
		 // rangeQueryBuilder.to(price);
		 // }
		 // boolQueryBuilder.filter(rangeQueryBuilder);
		 Iterable<CarsTransactionsVO> carsTransactionsList = carsTransactionsRepository.search(boolQueryBuilder);
		 return new ResponseEntity(carsTransactionsList, HttpStatus.OK);


		

	
	}

}
