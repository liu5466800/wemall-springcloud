package cn.segema.cloud.mall.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.common.page.Pager;
import cn.segema.cloud.common.page.PagerParamVO;
import cn.segema.cloud.common.utils.IdGeneratorUtil;
import cn.segema.cloud.common.vo.ResultVO;
import cn.segema.cloud.mall.domain.ProductCategory;
import cn.segema.cloud.mall.repository.ProductCategoryRepository;
import cn.segema.cloud.mall.service.ProductCategoryService;

@RestController
@RequestMapping(value = "/productCategory")
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryService productCategoryService;
 
  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  @GetMapping("/{productCategoryId}")
  public Optional<ProductCategory> findById(@PathVariable BigInteger productCategoryId) {
	  Optional<ProductCategory> findOne = this.productCategoryRepository.findById(productCategoryId);
    return findOne;
  }
  
  @GetMapping("/list")
	public List<ProductCategory> list(ProductCategory productCategory, Model model) {
		List<ProductCategory> productList = productCategoryRepository.findAll();
		return productList;
	}

	@PostMapping("/add")
	public ProductCategory add(ProductCategory productCategory, Model model) {
		if (productCategory.getCategoryId() == null || "".equals(productCategory.getCategoryId())) {
			productCategory.setCategoryId(BigInteger.valueOf(IdGeneratorUtil.generateSnowFlakeId()));
		}
		productCategoryRepository.save(productCategory);
		return productCategory;
	}

	@PutMapping(value = "/edit")
	public ProductCategory edit(ProductCategory productCategory, Model model) {
		// Role oldRole = roleRepository.getOne(role.getRoleId());
		// BeanUtils.copyProperties(role, oldRole);
		productCategoryRepository.save(productCategory);
		return productCategory;
	}

	@DeleteMapping(value = "/delete/{categoryId}")
	public ResultVO delete(@PathVariable("categoryId") BigInteger categoryId) {
		ResultVO resultVO = new ResultVO();
		productCategoryRepository.deleteById(categoryId);
		resultVO.addSuccess("删除成功");
		return resultVO;
	}
  
  @GetMapping("/listByPage")
	public Pager<ProductCategory> listByPage(PagerParamVO pagerParam) {
	  	Sort sort = new Sort(Direction.DESC, "categoryId");
		Pageable pageable = new PageRequest(pagerParam.getCurr()-1, pagerParam.getNums(), sort);
		Page<ProductCategory> page = productCategoryService.findByPage(pageable, pagerParam.getParams());
		Pager<ProductCategory> pager = new Pager<ProductCategory>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}
 
}
