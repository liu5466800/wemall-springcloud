package cn.segema.cloud.cms.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.cms.domain.ProductCategory;
import cn.segema.cloud.cms.repository.ProductCategoryRepository;
import cn.segema.cloud.common.page.Pager;

@RestController
@RequestMapping(value = "/productCategory")
public class ProductCategoryController {
 
  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  @GetMapping("/{productCategoryId}")
  public ProductCategory findById(@PathVariable BigInteger productCategoryId) {
    ProductCategory findOne = this.productCategoryRepository.findOne(productCategoryId);
    return findOne;
  }
  
  @GetMapping("/list")
	public List<ProductCategory> list(ProductCategory productCategory, Model model) {
		List<ProductCategory> productList = productCategoryRepository.findAll();
		return productList;
	}

	@PostMapping("/add")
	public ProductCategory add(ProductCategory productCategory, Model model) {
		productCategoryRepository.save(productCategory);
		return productCategory;
	}

	@RequestMapping(value = "edit")
	public ProductCategory edit(ProductCategory productCategory, Model model) {
		// Role oldRole = roleRepository.getOne(role.getRoleId());
		// BeanUtils.copyProperties(role, oldRole);
		productCategoryRepository.save(productCategory);
		return productCategory;
	}

	@RequestMapping(value = "delete")
	public ProductCategory delete(ProductCategory productCategory) {
		productCategoryRepository.delete(productCategory);
		return productCategory;
	}
  
  @GetMapping("/listByPage")
	public Pager<ProductCategory> listByPage() {
		Sort sort = new Sort(Direction.DESC, "productId");
		Pageable pageable = new PageRequest(0, 30, sort);
		Page<ProductCategory> page = productCategoryRepository.findAll(pageable);
		Pager<ProductCategory> pager = new Pager<ProductCategory>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}
 
}
