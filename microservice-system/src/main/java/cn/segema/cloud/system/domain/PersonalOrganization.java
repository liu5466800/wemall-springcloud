package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 人员组织关系
 * @author wangyong
 *
 */
@Table(name = "SYS_PERSONAL_ORGANIZATION")
@Entity
public class PersonalOrganization {
	@Id
	@Column(name = "PERSONALORGANIZATIONID")
	private BigInteger PersonalOrganizationId;

	@OneToOne
	@JoinColumn(name = "PERSONALID")
	private Personal personal;

	@OneToOne
	@JoinColumn(name = "ORGANIZATIONID")
	private Organization organization;

	public BigInteger getPersonalOrganizationId() {
		return PersonalOrganizationId;
	}

	public void setPersonalOrganizationId(BigInteger personalOrganizationId) {
		PersonalOrganizationId = personalOrganizationId;
	}

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

	

}
