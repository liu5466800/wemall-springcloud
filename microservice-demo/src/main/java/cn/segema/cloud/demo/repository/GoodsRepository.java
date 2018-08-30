package cn.segema.cloud.demo.repository;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.Resource;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.demo.vo.GoodsVO;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;

@Repository
public class GoodsRepository implements ElasticsearchRepository<GoodsVO, Integer> {

	@Resource
	private JestClient jestClient;

	@Override
	public Iterable<GoodsVO> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<GoodsVO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends GoodsVO> S save(S entity) {
		// TODO Auto-generated method stub
		GoodsVO book = new GoodsVO(1,"《西游记后传》","小白龙");

        //构建一个索引功能 参数为路径.../library/old/1
        Index index = new Index.Builder(book).index("library").type("old").id("3").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return null;
	}

	@Override
	public <S extends GoodsVO> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<GoodsVO> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<GoodsVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<GoodsVO> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(GoodsVO entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends GoodsVO> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends GoodsVO> S index(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<GoodsVO> search(QueryBuilder query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<GoodsVO> search(QueryBuilder query, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<GoodsVO> search(SearchQuery searchQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<GoodsVO> searchSimilar(GoodsVO entity, String[] fields, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<GoodsVO> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
