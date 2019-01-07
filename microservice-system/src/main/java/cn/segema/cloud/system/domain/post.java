package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 岗位
 * @author wangyong
 *
 */
@Table(name = "sys_post")
@Entity
public class post {
	@Id
	@Column(name = "post_id")
	private BigInteger postId;
	
	@Column(name = "post_name")
	private String postName;
	
	@Column(name = "post_code")
	private String systemCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "delete_status")
	private Integer deleteStatus;
	
	@Column(name = "create_time")
	private BigInteger createTime;

	public BigInteger getPostId() {
		return postId;
	}

	public void setPostId(BigInteger postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
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
