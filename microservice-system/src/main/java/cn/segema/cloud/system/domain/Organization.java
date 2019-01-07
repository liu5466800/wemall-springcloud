package cn.segema.cloud.system.domain;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 组织机构
 * @author wangyong
 *
 */
@Table(name = "sys_organization")
@Entity
public class Organization {
	@Id
	@Column(name = "organization_id")
	private BigInteger organizationId;

	@Column(name = "organization_name")
	private String organizationName;

	@Column(name = "organization_code")
	private BigInteger organizationCode;

	@Column(name = "description")
	private String description;

	@ManyToOne
    @JoinColumn(name="parent_id")
    private Organization parent;
	
	@Column(name = "type")
	private Integer type;
	
	@Column(name = "delete_status")
	private Integer deleteStatus;
	
	@Column(name = "create_time")
	private BigInteger createTime;
	
	@OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Set<Organization> children = new HashSet<Organization>();

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

	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
	}

	public Set<Organization> getChildren() {
		return children;
	}

	public void setChildren(Set<Organization> children) {
		this.children = children;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public BigInteger getCreateTime() {
		return createTime;
	}

	public void setCreateTime(BigInteger createTime) {
		this.createTime = createTime;
	}
	
}
