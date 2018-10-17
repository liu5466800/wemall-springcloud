package cn.segema.cloud.cms.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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

import cn.segema.cloud.cms.domain.ProductDetail;
import cn.segema.cloud.cms.repository.ProductDetailRepository;
import cn.segema.cloud.common.page.Pager;

@RestController
@RequestMapping(value = "/productDetail")
public class ProductDetailController {
 
  @Autowired
  private ProductDetailRepository productDetailRepository;

  @GetMapping("/{productDetailId}")
  public Optional<ProductDetail> findById(@PathVariable BigInteger productDetailId) {
	  Optional<ProductDetail> findOne = this.productDetailRepository.findById(productDetailId);
    return findOne;
  }
  
  @GetMapping("/list")
	public List<ProductDetail> list(ProductDetail productDetail, Model model) {
		List<ProductDetail> productDetailList = productDetailRepository.findAll();
		return productDetailList;
	}

	@PostMapping("/add")
	public ProductDetail add(ProductDetail productDetail, Model model) {
		productDetailRepository.save(productDetail);
		return productDetail;
	}

	@PutMapping(value = "edit")
	public ProductDetail edit(ProductDetail productDetail, Model model) {
		ProductDetail oldProductDetail = productDetailRepository.getOne(productDetail.getProductDetailId());
		BeanUtils.copyProperties(productDetail, oldProductDetail);
		productDetailRepository.save(productDetail);
		return productDetail;
	}

	@DeleteMapping(value = "delete")
	public ProductDetail delete(ProductDetail productDetail) {
		productDetailRepository.delete(productDetail);
		return productDetail;
	}
  
  @GetMapping("/listByPage")
	public Pager<ProductDetail> listByPage() {
		Sort sort = new Sort(Direction.DESC, "productId");
		Pageable pageable = new PageRequest(0, 30, sort);
		Page<ProductDetail> page = productDetailRepository.findAll(pageable);
		Pager<ProductDetail> pager = new Pager<ProductDetail>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}
 
}
