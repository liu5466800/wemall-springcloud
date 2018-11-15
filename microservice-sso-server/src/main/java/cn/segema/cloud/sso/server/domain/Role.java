package cn.segema.cloud.sso.server.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_role")
@Entity
public class Role implements Serializable {
	
	private static final long serialVersionUID = 7813962037134101133L;

	@Id
	@Column(name = "role_id")
	private BigInteger roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "role_code")
	private String roleCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "locked")
	private Integer locked;
	
	@Column(name = "delete_status")
	private Integer deletestatus;

	public BigInteger getRoleId() {
		return roleId;
	}

	public void setRoleId(BigInteger roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public Integer getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(Integer deletestatus) {
		this.deletestatus = deletestatus;
	}
}
