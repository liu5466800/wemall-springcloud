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

import cn.segema.cloud.cms.domain.Specification;
import cn.segema.cloud.cms.repository.SpecificationRepository;
import cn.segema.cloud.common.page.Pager;

@RestController
@RequestMapping(value = "/specification")
public class SpecificationController {
 
  @Autowired
  private SpecificationRepository specificationRepository;

  @GetMapping("/{specificationId}")
  public Optional<Specification> findById(@PathVariable BigInteger specificationId) {
	  Optional<Specification> findOne = this.specificationRepository.findById(specificationId);
    return findOne;
  }
  
  @GetMapping("/list")
	public List<Specification> list(Specification specification, Model model) {
		List<Specification> productList = specificationRepository.findAll();
		return productList;
	}

	@PostMapping("/add")
	public Specification add(Specification specification, Model model) {
		specificationRepository.save(specification);
		return specification;
	}

	@PutMapping(value = "edit")
	public Specification edit(Specification specification, Model model) {
		 Specification oldSpecification = specificationRepository.getOne(specification.getSpecificationId());
		 BeanUtils.copyProperties(specification, oldSpecification);
		specificationRepository.save(specification);
		return specification;
	}

	@DeleteMapping(value = "delete")
	public Specification delete(Specification specification) {
		specificationRepository.delete(specification);
		return specification;
	}
  
  @GetMapping("/listByPage")
	public Pager<Specification> listByPage() {
		Sort sort = new Sort(Direction.DESC, "specificationId");
		Pageable pageable = new PageRequest(0, 30, sort);
		Page<Specification> page = specificationRepository.findAll(pageable);
		Pager<Specification> pager = new Pager<Specification>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}
 
}
