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
import cn.segema.cloud.mall.domain.Category;
import cn.segema.cloud.mall.repository.CategoryRepository;
import cn.segema.cloud.mall.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/{categoryId}")
	public Optional<Category> findById(@PathVariable BigInteger categoryId) {
		Optional<Category> findOne = this.categoryRepository.findById(categoryId);
		return findOne;
	}

	@GetMapping("/list")
	public List<Category> list(Category category, Model model) {
		List<Category> productList = categoryRepository.findAll();
		return productList;
	}

	@PostMapping("/add")
	public Category add(Category category, Model model) {
		if (category.getCategoryId() == null || "".equals(category.getCategoryId())) {
			category.setCategoryId(BigInteger.valueOf(IdGeneratorUtil.generateSnowFlakeId()));
		}
		categoryRepository.save(category);
		return category;
	}

	@PutMapping(value = "/edit")
	public Category edit(Category category, Model model) {
		// Role oldRole = roleRepository.getOne(role.getRoleId());
		// BeanUtils.copyProperties(role, oldRole);
		categoryRepository.save(category);
		return category;
	}

	@DeleteMapping(value = "/delete/{categoryId}")
	public ResultVO delete(@PathVariable("categoryId") BigInteger categoryId) {
		ResultVO resultVO = new ResultVO();
		categoryRepository.deleteById(categoryId);
		resultVO.addSuccess("删除成功");
		return resultVO;
	}

	@GetMapping("/listByPage")
	public Pager<Category> listByPage(PagerParamVO pagerParam) {
		Sort sort = new Sort(Direction.DESC, "categoryId");
		Pageable pageable = new PageRequest(pagerParam.getCurr() - 1, pagerParam.getNums(), sort);
		Page<Category> page = categoryService.findByPage(pageable, pagerParam.getParams());
		Pager<Category> pager = new Pager<Category>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}

}
