package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 组织-人员关系
 * @author wangyong
 *
 */
@Table(name = "sys_organization_personal")
@Entity
public class OrganizationPersonal {
	@Id
	@Column(name = "organization_personal_id")
	private BigInteger organizationPersonalId;

	@OneToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;

	@OneToOne
	@JoinColumn(name = "personal_id")
	private Personal personal;
	
	@Column(name = "type")
	private Integer type;

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public BigInteger getOrganizationPersonalId() {
		return organizationPersonalId;
	}

	public void setOrganizationPersonalId(BigInteger organizationPersonalId) {
		this.organizationPersonalId = organizationPersonalId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
