package cn.segema.cloud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.segema.cloud.demo.domain.DemoRole;
import cn.segema.cloud.demo.domain.UserEntity;
import cn.segema.cloud.demo.mapper.DemoRoleMapper;
import cn.segema.cloud.demo.mapper.UserMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 角色Controller
 */
@RestController
@RequestMapping(value = "/demo/role")
public class DemoRoleController {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
    DemoRoleMapper demoRoleMapper;

	@ApiOperation(value="获取角色信息", notes="根据id获取角色信息")
	  @ApiImplicitParams({  
	          @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType="path")  
	  })
	@GetMapping("/{id}")
	public DemoRole findById(@PathVariable int id) {
		DemoRole findOne = demoRoleMapper.findRoleById(id);
		return findOne;
	}

	@ApiOperation(value="获取角色列表", notes="根据条件获取角色列表")
	  @ApiImplicitParams({  
	          @ApiImplicitParam(name = "roleId", value = "用户ID", required = true, dataType = "String", paramType="path")  
	  })
	@GetMapping("/list")
	public List<DemoRole> list(DemoRole role, Model model) {
		List<DemoRole> list = demoRoleMapper.findAllRoles();
		return list;
	}

	@PostMapping("/add")
	public DemoRole add(DemoRole role, Model model) {
		if (role.getRoleId() == null || "".equals(role.getRoleId())) {
			role.setRoleId(1);
		}
		demoRoleMapper.insertRole(role);
		return role;
	}

	@RequestMapping(value = "edit")
	public DemoRole edit(DemoRole role, Model model) {
		return role;
	}

	@RequestMapping(value = "delete")
	@Transactional
	public DemoRole delete(DemoRole role) {
		//roleService.delete(role);
		return role;
	}
	
	@GetMapping("/findByPage")
	public PageInfo<DemoRole> findByPage(int page,int pageSize) {
		PageHelper.startPage(page, pageSize); //底层采用改写语句
		List<DemoRole> list = demoRoleMapper.findAllRoles();
		PageInfo<DemoRole> pageInfoDemoRoleList = new PageInfo<DemoRole>(list);
		return pageInfoDemoRoleList;
	}

}
