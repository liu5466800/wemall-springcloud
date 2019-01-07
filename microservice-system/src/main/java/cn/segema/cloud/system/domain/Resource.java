package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 资源
 * 
 * @author wangyong
 *
 */
@Table(name = "sys_resource")
@Entity
public class Resource {
	@Id
	@Column(name = "resource_id")
	private BigInteger resourceId;
	
	@Column(name = "resource_name")
	private String resourceName;
	
	@Column(name = "parent_id")
	private String parentId;
	
	@Column(name = "resource_code")
	private String resourceCode;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "resource_url")
	private String resourceUrl;
	
	@Column(name = "rank")
	private String rank;
	
	@Column(name = "icon")
	private String icon;
	
	@Column(name = "hide")
	private Integer hide;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "delete_status")
	private Integer deleteStatus;

	@Column(name = "create_time")
	private BigInteger createTime;
	
	public BigInteger getResourceId() {
		return resourceId;
	}

	public void setResourceId(BigInteger resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Integer getHide() {
		return hide;
	}

	public void setHide(Integer hide) {
		this.hide = hide;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
