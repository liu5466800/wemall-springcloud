package cn.segema.cloud.mall.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.segema.cloud.mall.domain.Product;
import cn.segema.cloud.mall.repository.ProductRepository;

@Service
public class ProductService {
	
	@Resource(name = "productRepository")
    private ProductRepository productRepository;
	
	 public List<Product> getAll() {
	        return (List<Product>) productRepository.findAll();
	    }
	 
	 public Page<Product> findByPage(Pageable pageable,final Map<String, String> params){

	        Page<Product> objPage = productRepository.findAll(new Specification<Product>() {

	            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
	                List<Predicate> lstPredicates = new ArrayList<Predicate>();
	                if (params.get("productName")!=null && (!"".equals(params.get("productName")))) {
	                    lstPredicates.add(cb.like(root.get("productName").as(String.class), "%" + params.get("productName") + "%"));
	                }
	                Predicate[] arrayPredicates = new Predicate[lstPredicates.size()];
	                return cb.and(lstPredicates.toArray(arrayPredicates));
	            }
	        }, pageable);

	        return objPage;
	    }
	
}
