package cn.segema.cloud.demo.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.segema.cloud.demo.domain.DemoRole;
import cn.segema.cloud.demo.repository.DemoRoleRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 角色Controller
 */
@Controller
@RequestMapping(value = "/demo/role")
public class DemoRoleController {

	@Autowired
	private DemoRoleRepository roleRepository;

	@ApiOperation(value="获取角色信息", notes="根据id获取角色信息")
	  @ApiImplicitParams({  
	          @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType="path")  
	  })
	@GetMapping("/{id}")
	public Optional<DemoRole> findById(@PathVariable BigInteger id) {
		 Optional<DemoRole> findOne = this.roleRepository.findById(id);
		return findOne;
	}

	@GetMapping("/list")
	public List<DemoRole> list(DemoRole role, Model model) {
		List<DemoRole> list = roleRepository.findAll();
		return list;
	}

	@PostMapping("/add")
	public DemoRole add(DemoRole role, Model model) {
		if (role.getRoleId() == null || "".equals(role.getRoleId())) {
			role.setRoleId(UUID.randomUUID().toString());
		}
		roleRepository.save(role);
		return role;
	}

	@RequestMapping(value = "edit")
	public DemoRole edit(DemoRole role, Model model) {
		roleRepository.save(role);
		return role;
	}

	@RequestMapping(value = "delete")
	public DemoRole delete(DemoRole role) {
		roleRepository.delete(role);
		return role;
	}

}
