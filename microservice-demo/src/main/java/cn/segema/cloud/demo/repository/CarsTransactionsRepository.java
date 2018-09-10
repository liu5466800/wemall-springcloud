package cn.segema.cloud.demo.repository;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.Resource;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.demo.vo.CarsTransactionsVO;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

@Repository
public class CarsTransactionsRepository implements ElasticsearchRepository<CarsTransactionsVO, String> {

	@Resource
	private JestClient jestClient;

	private static String indexName = "cars";

	private static String indexType = "transactions";

	@Override
	public Iterable<CarsTransactionsVO> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CarsTransactionsVO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CarsTransactionsVO> S save(S entity) {
		Index index = new Index.Builder(entity).index("cars").type("transactions").id(entity.getId()).build();
		try {
			DocumentResult result = jestClient.execute(index);
			if (HttpStatus.CREATED.equals(result.getResponseCode())) {
				entity.setId(result.getId());
				return entity;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public <S extends CarsTransactionsVO> Iterable<S> saveAll(Iterable<S> entities) {
		Index index = new Index.Builder(entities).index("cars").type("transactions").build();
		try {
			jestClient.execute(index);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Optional<CarsTransactionsVO> findById(String id) {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		boolQueryBuilder.filter().add(QueryBuilders.matchQuery("id", id));
		searchSourceBuilder.query(boolQueryBuilder);
		Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(indexName).addType(indexType).build();
		SearchResult result = null;
		try {
			result = jestClient.execute(search);
			
			return Optional.of(new CarsTransactionsVO());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Optional<CarsTransactionsVO> cars = Optional.empty();

		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<CarsTransactionsVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CarsTransactionsVO> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CarsTransactionsVO entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends CarsTransactionsVO> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends CarsTransactionsVO> S index(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CarsTransactionsVO> search(QueryBuilder query) {
		
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		//boolQueryBuilder.filter().add(QueryBuilders.matchQuery("id", id));
		searchSourceBuilder.query(boolQueryBuilder);
		Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(indexName).addType(indexType).build();
		SearchResult result = null;
		try {
			result = jestClient.execute(search);
			
			//return Optional.of(new CarsTransactionsVO());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Optional<CarsTransactionsVO> cars = Optional.empty();

//		
//		SearchRequestBuilder searchRequestBuilder = client.prepareSearch(indexName).setTypes(indexType)
//				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(boolQueryBuilder).setFrom(0).setSize(100);
//		System.out.println(searchRequestBuilder);
//
//		SearchResponse response = searchRequestBuilder.get();
//		List<Map<String, Object>> result = new ArrayList<>();
//		for (SearchHit hit : response.getHits()) {
//			result.add(hit.getSource());
//		}
//
//		return new ResponseEntity(result, HttpStatus.OK);
//		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CarsTransactionsVO> search(QueryBuilder query, Pageable pageable) {

		Search search = new Search.Builder(query.toString()).addIndex(indexName).addType(indexType).build();
		SearchResult result = null;
		try {
			result = jestClient.execute(search);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Page<CarsTransactionsVO> search(SearchQuery searchQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CarsTransactionsVO> searchSimilar(CarsTransactionsVO entity, String[] fields, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<CarsTransactionsVO> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
