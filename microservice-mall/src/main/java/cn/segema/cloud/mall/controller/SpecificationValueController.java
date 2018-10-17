package cn.segema.cloud.mall.controller;

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

import cn.segema.cloud.common.page.Pager;
import cn.segema.cloud.mall.domain.SpecificationValue;
import cn.segema.cloud.mall.repository.SpecificationValueRepository;

@RestController
@RequestMapping(value = "/specificationValue")
public class SpecificationValueController {
 
  @Autowired
  private SpecificationValueRepository specificationValueRepository;

  @GetMapping("/{productId}")
  public Optional<SpecificationValue> findById(@PathVariable BigInteger specificationValueId) {
	  Optional<SpecificationValue> findOne = this.specificationValueRepository.findById(specificationValueId);
    return findOne;
  }
  
  @GetMapping("/list")
	public List<SpecificationValue> list(SpecificationValue specificationValue, Model model) {
		List<SpecificationValue> specificationValueList = specificationValueRepository.findAll();
		return specificationValueList;
	}

	@PostMapping("/add")
	public SpecificationValue add(SpecificationValue specificationValue, Model model) {
		specificationValueRepository.save(specificationValue);
		return specificationValue;
	}

	@PutMapping(value = "edit")
	public SpecificationValue edit(SpecificationValue specificationValue, Model model) {
		SpecificationValue oldSpecificationValue = specificationValueRepository.getOne(specificationValue.getValueId());
		 BeanUtils.copyProperties(specificationValue, oldSpecificationValue);
		specificationValueRepository.save(specificationValue);
		return specificationValue;
	}

	@DeleteMapping(value = "delete")
	public SpecificationValue delete(SpecificationValue specificationValue) {
		specificationValueRepository.delete(specificationValue);
		return specificationValue;
	}
  
  @GetMapping("/listByPage")
	public Pager<SpecificationValue> listByPage() {
		Sort sort = new Sort(Direction.DESC, "productId");
		Pageable pageable = new PageRequest(0, 30, sort);
		Page<SpecificationValue> page = specificationValueRepository.findAll(pageable);
		Pager<SpecificationValue> pager = new Pager<SpecificationValue>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}
 
}
