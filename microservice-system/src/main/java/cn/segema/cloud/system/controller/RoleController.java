package cn.segema.cloud.system.controller;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.segema.cloud.common.constants.ApiConstant;
import cn.segema.cloud.common.utils.IdGeneratorUtil;
import cn.segema.cloud.system.domain.Role;
import cn.segema.cloud.system.repository.RoleRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 角色Controller
 */
@Controller
@RequestMapping(value = ApiConstant.API_VERSION + "/roles")
public class RoleController {

	@Autowired
	private RoleRepository roleRepository;

	@ApiOperation(value = "新增角色", notes = "新增角色")
	@PostMapping("/add")
	public Role add(Role role) {
		if (role.getRoleId() == null) {
			role.setRoleId(BigInteger.valueOf(IdGeneratorUtil.generateSnowFlakeId()));
		}
		roleRepository.save(role);
		return role;
	}

	@ApiOperation(value = "修改角色", notes = "修改角色")
	@PutMapping
	public Role edit(Role role) {
		roleRepository.save(role);
		return role;
	}

	@ApiOperation(value = "删除角色", notes = "删除角色")
	@DeleteMapping
	public Role delete(Role role) {
		roleRepository.delete(role);
		return role;
	}

	@ApiOperation(value = "根据id获取角色", notes = "根据id获取角色")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "roleId", value = "角色id", required = true, paramType = "path") })
	@GetMapping("/{roleId}")
	public Optional<Role> findById(@PathVariable BigInteger roleId) {
		Optional<Role> findOne = this.roleRepository.findById(roleId);
		return findOne;
	}

	@ApiOperation(value = "分页获取角色", notes = "分页获取角色")
	@ApiImplicitParams({@ApiImplicitParam(name = "page", value = "当前页", required = true, paramType = "query"),
		@ApiImplicitParam(name = "limit", value = "每页数", required = true, paramType = "query"),
		@ApiImplicitParam(name = "sort", value = "排序列", required = false, paramType = "query")})
	@GetMapping("/page")
	public Page<Role> findByPage(@RequestParam(defaultValue ="1") int page, 
			@RequestParam(defaultValue = "20") int limit, 
			@RequestParam(defaultValue = "roleId") String sort) {
		Sort sortOrder = new Sort(Sort.Direction.DESC, sort);
		Pageable pageable = PageRequest.of(page - 1, limit, sortOrder);
		Page<Role> roleList = roleRepository.findAll(pageable);
		return roleList;
	}
}
