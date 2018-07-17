package cn.segema.cloud.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.common.page.Pager;
import cn.segema.cloud.common.utils.IdGeneratorUtil;
import cn.segema.cloud.demo.domain.DemoUser;
import cn.segema.cloud.demo.repository.DemoRepository;
import cn.segema.cloud.demo.vo.DemoUserPersonalVO;
import cn.segema.cloud.demo.vo.TestEmployeeVO;
import cn.segema.cloud.demo.vo.TestUserVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/demo/user")
public class DemoUserController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private DemoRepository demoRepository;

	@GetMapping("/{userId}")
	public DemoUser findById(@PathVariable String userId) {
		DemoUser findOne = this.demoRepository.findOne(userId);
		
		Date today = new Date();
		today.getTime();
		
		DemoUser demoUser  = new DemoUser();
		demoUser.setUserId(String.valueOf(IdGeneratorUtil.generateSnowFlakeId()));
		demoUser.setUserName("todayname");
		demoUser.setCreateTime(new Date(today.getTime()));
		demoRepository.save(demoUser);
		
		return findOne;
	}

	@GetMapping("/list")
	public List<DemoUser> list(DemoUser user, Model model) {
		List<DemoUser> userList = demoRepository.findAll();
		return userList;
	}

	@ApiOperation(value="新增用户信息", notes="新增用户信息")
	@PostMapping("/add")
	public TestUserVO add(TestUserVO user, Model model) {
		
		
		

		System.out.println("------user:----------");

		return user;
	}

	@GetMapping("/getTable")
	public List<TestEmployeeVO> getTable(List<TestEmployeeVO> employees, Model model) {
		List<DemoUser> userList = demoRepository.findAll();

		return employees;
	}

	@RequestMapping(value = "/editTable", method = { RequestMethod.POST })
	@ResponseBody
	public List<TestEmployeeVO> editTable(@RequestBody String employeesStr) {
		// @RequestParam(value = "data[]")long[] data

		System.out.println("---------employees:" + employeesStr + "-------");

		List<TestEmployeeVO> employeeList = new ArrayList<TestEmployeeVO>();

		return employeeList;
	}

	@RequestMapping(value = "edit")
	public DemoUser edit(DemoUser user, Model model) {
		// Role oldRole = roleRepository.getOne(role.getRoleId());
		// BeanUtils.copyProperties(role, oldRole);
		demoRepository.save(user);
		return user;
	}

	@RequestMapping(value = "delete")
	public DemoUser delete(DemoUser user) {
		demoRepository.delete(user);
		return user;
	}

	/**
	 * 关联实体查询
	 * 
	 * @param userName
	 * @return
	 */
	@GetMapping("/listUserPersonalByUserName/{userName}")
	public List<DemoUserPersonalVO> listUserPersonalByUserName(@PathVariable String userName) {
		List<DemoUserPersonalVO> userList = demoRepository.findUserPersonalByUserName(userName);
		return userList;
	}

	@GetMapping("/listByPage")
	public Pager<DemoUser> listByPage() {
		Sort sort = new Sort(Direction.DESC, "userId");
		Pageable pageable = new PageRequest(0, 30, sort);
		Page<DemoUser> page = demoRepository.findAll(pageable);
		Pager<DemoUser> pager = new Pager<DemoUser>();
		pager.setCode("0");
		pager.setMsg("success");
		pager.setCount(page.getTotalElements());
		pager.setData(page.getContent());
		return pager;
	}

	/**
	 * 本地服务实例的信息
	 * 
	 * @return
	 */
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}
}
