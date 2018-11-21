package cn.segema.cloud.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import cn.segema.cloud.demo.vo.CarTransactionVO;

@Repository
public interface DemoCarTransactionRepository extends ElasticsearchRepository<CarTransactionVO, String> {

}
