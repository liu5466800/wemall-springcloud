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

import cn.segema.cloud.mall.domain.ProductCategory;
import cn.segema.cloud.mall.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {
	
	@Resource(name = "productCategoryRepository")
    private ProductCategoryRepository productCategoryRepository;
	
	 public List<ProductCategory> getAll() {
	        return (List<ProductCategory>) productCategoryRepository.findAll();
	    }
	 
	 public Page<ProductCategory> findByPage(Pageable pageable,final Map<String, String> params){

	        Page<ProductCategory> objPage = productCategoryRepository.findAll(new Specification<ProductCategory>() {

	            public Predicate toPredicate(Root<ProductCategory> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
	                List<Predicate> lstPredicates = new ArrayList<Predicate>();
	                if (params.get("categoryName")!=null && (!"".equals(params.get("categoryName")))) {
	                    lstPredicates.add(cb.like(root.get("categoryName").as(String.class), "%" + params.get("categoryName") + "%"));
	                }
	                Predicate[] arrayPredicates = new Predicate[lstPredicates.size()];
	                return cb.and(lstPredicates.toArray(arrayPredicates));
	            }
	        }, pageable);

	        return objPage;
	    }
	
}
