package cn.segema.cloud.system.vo;

import java.math.BigInteger;

/**
 * 组织机构人员信息
 * @author wangyong
 */
public class OrganizationPersonalVO {

	private BigInteger organizationId;

	private String organizationName;

	private BigInteger organizationCode;

	private BigInteger personalId;

	private String personalName;

	private Integer type;

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

	public BigInteger getPersonalId() {
		return personalId;
	}

	public void setPersonalId(BigInteger personalId) {
		this.personalId = personalId;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public OrganizationPersonalVO(BigInteger organizationId, String organizationName, BigInteger organizationCode,
			BigInteger personalId, String personalName, Integer type) {
		super();
		this.organizationId = organizationId;
		this.organizationName = organizationName;
		this.organizationCode = organizationCode;
		this.personalId = personalId;
		this.personalName = personalName;
		this.type = type;
	}

}
