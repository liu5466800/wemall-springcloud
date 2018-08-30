package cn.segema.cloud.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.demo.repository.GoodsRepository;
import cn.segema.cloud.demo.vo.GoodsVO;

@RestController
public class GoodsController {
	@Autowired
	private GoodsRepository goodsRepository;

	// http://localhost:8888/save
	@GetMapping("save")
	public String save() {
		GoodsVO GoodsVO = new GoodsVO();
		goodsRepository.save(GoodsVO);
		return "success";
	}

	// http://localhost:8888/delete?id=1525415333329
	@GetMapping("delete")
	public String delete(Integer id) {
		goodsRepository.deleteById(id);
		return "success";
	}

	// http://localhost:8888/update?id=1525417362754&name=修改&description=修改
	@GetMapping("update")
	public String update(Integer id, String name, String description) {
		GoodsVO GoodsVO = new GoodsVO(id, name, description);
		goodsRepository.save(GoodsVO);
		return "success";
	}

	// http://localhost:8888/getOne?id=1525417362754
	@GetMapping("getOne")
	public Optional<GoodsVO> getOne(Integer id) {
		Optional<GoodsVO> GoodsVO = goodsRepository.findById(id);
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
