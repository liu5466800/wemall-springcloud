package cn.segema.cloud.system.vo;

import java.math.BigInteger;
import java.util.List;

public class OrganizationTreeVO {

	private BigInteger organizationId;

	private String organizationName;

	private BigInteger organizationCode;

	private List<OrganizationTreeVO> children;

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

	public List<OrganizationTreeVO> getChildren() {
		return children;
	}

	public void setChildren(List<OrganizationTreeVO> children) {
		this.children = children;
	}

}
