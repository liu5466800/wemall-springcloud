package cn.segema.cloud.sso.server.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public class RoleVO implements Serializable {

	private static final long serialVersionUID = 1960667607641277046L;

	private BigInteger roleId;

	/**
	 * 角色编码
	 */
	private String roleCode;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 角色拥有的资源
	 */
	private List<ResourceVO> resourceList;

	public BigInteger getRoleId() {
		return roleId;
	}

	public void setRoleId(BigInteger roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<ResourceVO> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<ResourceVO> resourceList) {
		this.resourceList = resourceList;
	}

	public RoleVO() {
	}

	public RoleVO(String roleCode, String roleName) {
		this.roleCode = roleCode;
		this.roleName = roleName;
	}
}
