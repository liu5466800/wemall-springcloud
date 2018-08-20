package cn.segema.cloud.wemall.order.controller;

import java.util.List;
import java.util.Optional;

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
import cn.segema.cloud.common.utils.IdGeneratorUtil;
import cn.segema.cloud.wemall.order.domain.Order;
import cn.segema.cloud.wemall.order.repository.OrderRepository;

/**
 * 订单Controller
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

  @Autowired
  private OrderRepository orderRepository;
  
  /**
   * @param id
   * @return user信息
   */
  @GetMapping("/{orderId}")
  public Optional<Order> findById(@PathVariable Long orderId) throws Exception {
	  Optional<Order> order = this.orderRepository.findById(orderId);
    return order;
  }
  
  @GetMapping("/list")
	public List<Order> list(Order user, Model model) {
		List<Order> userList = orderRepository.findAll();
		return userList;
	}

	@PostMapping("/add")
	public Order add(Order user, Model model) {
		user.setOrderId(IdGeneratorUtil.generateSnowFlakeId());
		orderRepository.save(user);
		return user;
	}

	@RequestMapping(value = "edit")
	public Order edit(Order user, Model model) {
		// Role oldRole = roleRepository.getOne(role.getRoleId());
		// BeanUtils.copyProperties(role, oldRole);
		orderRepository.save(user);
		return user;
	}

	@RequestMapping(value = "delete")
	public Order delete(Order user) {
		orderRepository.delete(user);
		return user;
	}
  
  @GetMapping("/listByPage")
	public Pager<Order> listByPage(PagerParamVO pagerParam) {
		Sort sort = new Sort(Direction.DESC, "userId");
		Pageable pageable = new PageRequest(pagerParam.getCurr()-1, pagerParam.getNums(), sort);
		Page<Order> page = orderRepository.findAll(pageable);
		Pager<Order> pager = new Pager<Order>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}

}
