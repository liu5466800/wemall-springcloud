package cn.segema.cloud.system.vo;

import java.math.BigInteger;

/**
 * 组织机构信息VO(排除chidren,parent)
 * @author wangyong
 */
public class OrganizationVO{
	
	private BigInteger organizationId;

	private String organizationName;

	private BigInteger organizationCode;

	private String description;
    
	private Integer type;
	
	 private BigInteger parentId;

	public BigInteger getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(BigInteger organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public BigInteger getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(BigInteger organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigInteger getParentId() {
		return parentId;
	}

	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
	}


}
