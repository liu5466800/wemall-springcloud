package cn.segema.cloud.demo.repository;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.Resource;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.demo.vo.GoodsBookVO;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;

@Repository
public class GoodsBookRepository{

	@Resource
	private JestClient jestClient;

	public Iterable<GoodsBookVO> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<GoodsBookVO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public GoodsBookVO save(GoodsBookVO book) {
        Index index = new Index.Builder(book).index("library").type("old").id("3").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return book;
	}

	public <S extends GoodsBookVO> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<GoodsBookVO> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}




	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	public void delete(GoodsBookVO entity) {
		// TODO Auto-generated method stub

	}

	public void deleteAll(Iterable<? extends GoodsBookVO> entities) {
		// TODO Auto-generated method stub

	}


	public Iterable<GoodsBookVO> search(QueryBuilder query) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<GoodsBookVO> search(QueryBuilder query, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<GoodsBookVO> search(SearchQuery searchQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<GoodsBookVO> searchSimilar(GoodsBookVO entity, String[] fields, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
