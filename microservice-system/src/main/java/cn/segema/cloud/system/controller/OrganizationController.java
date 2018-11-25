package cn.segema.cloud.system.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.system.domain.Organization;
import cn.segema.cloud.system.repository.OrganizationRepository;
import cn.segema.cloud.system.vo.OrganizationPersonalVO;
import cn.segema.cloud.system.vo.OrganizationTreeVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 组织机构Controller
 */
@RestController
@RequestMapping(value = "/organizations")
public class OrganizationController {
	
	@Autowired
	private OrganizationRepository organizationRepository;


	@ApiOperation(value = "新增组织机构", notes = "新增组织机构")
	@PostMapping
	public Organization add(Organization organization) {
		if(organization.getParent()!=null){
			BigInteger maxOrganizationCode = organizationRepository.findMaxOrganization(organization.getParent().getOrganizationId());
			if(maxOrganizationCode!=null) {
				if(organization.getOrganizationCode()!=null) {
					if(organization.getOrganizationCode().compareTo(maxOrganizationCode)>0) {
						
						organization.setOrganizationId(organization.getOrganizationCode());
					}
				}else {
					organization.setOrganizationCode(maxOrganizationCode.add(BigInteger.ONE));
					organization.setOrganizationId(maxOrganizationCode.add(BigInteger.ONE));
				}
			}else {
				String organizationCode = organization.getParent().getOrganizationId()+"001";
				organization.setOrganizationCode(BigInteger.valueOf(Long.valueOf(organizationCode)));
				organization.setOrganizationId(BigInteger.valueOf(Long.valueOf(organizationCode)));
			}
		}
		organizationRepository.save(organization);
		return organization;
	}

	@ApiOperation(value = "修改组织机构", notes = "修改组织机构")
	@PutMapping
	public Organization edit(Organization organization) {
		organizationRepository.save(organization);
		return organization;
	}

	@ApiOperation(value = "删除组织机构", notes = "删除组织机构")
	@DeleteMapping
	public Organization delete(Organization organization) {
		organizationRepository.delete(organization);
		return organization;
	}
	
	@ApiOperation(value = "根据id获取组织机构", notes = "根据id获取组织机构")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "组织机构id", required = true, paramType = "path") })
	@GetMapping("/{organizationId}")
	public Optional<Organization> findById(@PathVariable BigInteger organizationId) throws Exception {
		Optional<Organization> organization = organizationRepository.findById(organizationId);
		return organization;
	}

	@ApiOperation(value = "根据名称获取组织机构", notes = "根据名称获取组织机构")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userName", value = "组织机构名称", required = true, paramType = "path") })
	@GetMapping("/personal/{organizationName}")
	public List<OrganizationPersonalVO> findPersonalByName(@PathVariable String organizationName) {
		List<OrganizationPersonalVO> organizationList = organizationRepository.findOrganizationPersonalByName(organizationName);
		return organizationList;
	}

	@ApiOperation(value = "分页获取用户", notes = "分页获取用户")
	@ApiImplicitParams({@ApiImplicitParam(name = "page", value = "当前页", required = true, paramType = "query"),
		@ApiImplicitParam(name = "limit", value = "每页数", required = true, paramType = "query"),
		@ApiImplicitParam(name = "sort", value = "排序列", required = false, paramType = "query")})
	@GetMapping("/page")
	public Page<Organization> findByPage(@RequestParam(defaultValue ="1") int page, 
			@RequestParam(defaultValue = "20") int limit, 
			@RequestParam(defaultValue = "organizationId") String sort) {
		Sort sortOrder = new Sort(Sort.Direction.DESC, sort);
		Pageable pageable = PageRequest.of(page - 1, limit, sortOrder);
		Page<Organization> organizationList = organizationRepository.findAll(pageable);
		return organizationList;
	}
	
	@ApiOperation(value = "根据节点id获取最大编码", notes = "根据节点id获取最大编码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parentId", value = "父级节点id", required = true, paramType = "path") })
	@GetMapping("/max-code/{parentId}")
	public BigInteger findMaxCode(@PathVariable BigInteger parentId) {
		BigInteger organizationCode = organizationRepository.findMaxOrganization(parentId);
		return organizationCode;
	}
	
	@ApiOperation(value = "根据节点id获取组织机构树", notes = "根据节点id获取组织机构树")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parentId", value = "父级节点id", required = true, paramType = "path") })
	@GetMapping("/tree-list/{parentId}")
	public List<OrganizationTreeVO> findTreeList(@PathVariable String parentId) {
		List<Organization> organizationList = organizationRepository.findTreeList(parentId);
		List<OrganizationTreeVO> treeList = new ArrayList<OrganizationTreeVO>();
		if(organizationList!=null&&organizationList.size()>0) {
			for(Organization organization:organizationList) {
				OrganizationTreeVO organizationTreeVO = new OrganizationTreeVO();
				organizationTreeVO.setOrganizationId(organization.getOrganizationId());
				organizationTreeVO.setOrganizationName(organization.getOrganizationName());
				organizationTreeVO.setChildren(null);
				treeList.add(organizationTreeVO);
			}
		}
		return treeList;
	}

}
