package cn.segema.cloud.cms.controller;

import java.math.BigInteger;
import java.util.List;

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

import cn.segema.cloud.cms.domain.Product;
import cn.segema.cloud.cms.domain.ProductCategory;
import cn.segema.cloud.cms.repository.ProductRepository;
import cn.segema.cloud.cms.service.ProductService;
import cn.segema.cloud.common.page.Pager;
import cn.segema.cloud.common.page.PagerParamVO;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/{productId}")
	public Product findById(@PathVariable BigInteger productId) {
		Product findOne = this.productRepository.findOne(productId);
		return findOne;
	}

	@GetMapping("/list")
	public List<Product> list(Product product, Model model) {
		List<Product> productList = productRepository.findAll();
		return productList;
	}

	@PostMapping("/add")
	public Product add(Product product, Model model) {
		productRepository.save(product);
		return product;
	}

	@PutMapping(value = "edit")
	public Product edit(Product product, Model model) {
		Product oldProduct = productRepository.getOne(product.getProductId());
		BeanUtils.copyProperties(product, oldProduct);
		productRepository.save(product);
		return product;
	}

	@DeleteMapping(value = "delete")
	public Product delete(Product product) {
		productRepository.delete(product);
		return product;
	}

	@GetMapping("/listByPage")
	public Pager<Product> listByPage(PagerParamVO pagerParam) {
		Sort sort = new Sort(Direction.DESC, "productId");
		Pageable pageable = new PageRequest(pagerParam.getCurr() - 1, pagerParam.getNums(), sort);
		Page<Product> page = productService.findByPage(pageable, pagerParam.getParams());
		Pager<Product> pager = new Pager<Product>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}

}
