package cn.segema.cloud.wemall.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import cn.segema.cloud.common.page.Pager;
import cn.segema.cloud.common.page.PagerParamVO;
import cn.segema.cloud.wemall.domain.Product;
import cn.segema.cloud.wemall.repository.ProductRepository;

/**
 * 用户Controller
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

  @Autowired
  private ProductRepository userRepository;
  
  /**
   * @param id
   * @return user信息
   */
  @GetMapping("/{userId}")
  public Optional<Product> findById(@PathVariable Long userId) throws Exception {
	  Optional<Product> user = this.userRepository.findById(userId);
    return user;
  }
  
  @GetMapping("/list")
	public List<Product> list(Product user, Model model) {
		List<Product> userList = userRepository.findAll();
		return userList;
	}

	@PostMapping("/add")
	public Product add(Product user, Model model) {
		if (user.getUserId() == null || "".equals(user.getUserId())) {
			user.setUserId(UUID.randomUUID().toString());
		}
		userRepository.save(user);
		return user;
	}

	@RequestMapping(value = "edit")
	public Product edit(Product user, Model model) {
		// Role oldRole = roleRepository.getOne(role.getRoleId());
		// BeanUtils.copyProperties(role, oldRole);
		userRepository.save(user);
		return user;
	}

	@RequestMapping(value = "delete")
	public Product delete(Product user) {
		userRepository.delete(user);
		return user;
	}
  
  
  @GetMapping("/listByPage")
	public Pager<Product> listByPage(PagerParamVO pagerParam) {
		Sort sort = new Sort(Direction.DESC, "userId");
		Pageable pageable = new PageRequest(pagerParam.getCurr()-1, pagerParam.getNums(), sort);
		Page<Product> page = userRepository.findAll(pageable);
		Pager<Product> pager = new Pager<Product>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}
  
}
