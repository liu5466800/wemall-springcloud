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

import cn.segema.cloud.mall.domain.Category;
import cn.segema.cloud.mall.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Resource(name = "categoryRepository")
    private CategoryRepository categoryRepository;
	
	 public List<Category> getAll() {
	        return (List<Category>) categoryRepository.findAll();
	    }
	 
	 public Page<Category> findByPage(Pageable pageable,final Map<String, String> params){

	        Page<Category> objPage = categoryRepository.findAll(new Specification<Category>() {

	            public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
