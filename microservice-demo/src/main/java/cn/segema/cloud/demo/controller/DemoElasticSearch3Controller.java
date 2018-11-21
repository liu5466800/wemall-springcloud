package cn.segema.cloud.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.demo.repository.DemoGoodsBookRepository;
import cn.segema.cloud.demo.vo.DemoGoodsBookVO;

@RestController
@RequestMapping(value = "/demo/elastic_search3")
public class DemoElasticSearch3Controller {
	@Autowired
	private DemoGoodsBookRepository goodsRepository;

	@GetMapping("/save")
	public String save() {
		DemoGoodsBookVO goodsBookVO = new DemoGoodsBookVO();
		goodsBookVO.setId(1);
		goodsBookVO.setName("测试书");
		goodsBookVO.setAnthony("金庸");
		goodsRepository.save(goodsBookVO);
		return "success";
	}

	@GetMapping("delete")
	public String delete(Integer id) {
		goodsRepository.deleteById(id);
		return "success";
	}

	@GetMapping("update")
	public String update(Integer id, String name, String description) {
		DemoGoodsBookVO GoodsVO = new DemoGoodsBookVO(id, name, description);
		goodsRepository.save(GoodsVO);
		return "success";
	}

	@GetMapping("getOne")
	public Optional<DemoGoodsBookVO> getOne(Integer id) {
		Optional<DemoGoodsBookVO> GoodsVO = goodsRepository.findById(id);
		return GoodsVO;
	}

	// 每页数量
	private Integer PAGESIZE = 10;

	// http://localhost:8888/getGoodsList?query=商品
	// http://localhost:8888/getGoodsList?query=商品&pageNumber=1
	// 根据关键字"商品"去查询列表，name或者description包含的都查询
//	@GetMapping("getGoodsList")
//	public List<GoodsVO> getList(Integer pageNumber, String query) {
//		if (pageNumber == null)
//			pageNumber = 0;
//		// es搜索默认第一页页码是0
//		SearchQuery searchQuery = getEntitySearchQuery(pageNumber, PAGESIZE, query);
//		Page<GoodsVO> goodsPage = goodsRepository.search(searchQuery);
//		return goodsPage.getContent();
//	}

//	private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
//		//FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(QueryBuilders.boolQuery())
//		FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.boolQuery()
//				.add(QueryBuilders.matchPhraseQuery("name", searchContent),
//						ScoreFunctionBuilders.weightFactorFunction(100))
//				.add(QueryBuilders.matchPhraseQuery("description", searchContent),
//						ScoreFunctionBuilders.weightFactorFunction(100))
//				// 设置权重分 求和模式
//				.scoreMode("sum")
//				// 设置权重分最低分
//				.setMinScore(10);
//
//		// 设置分页
//		Pageable pageable = new PageRequest(pageNumber, pageSize);
//		return new NativeSearchQueryBuilder().withPageable(pageable).withQuery(functionScoreQueryBuilder).build();
//	}
}
