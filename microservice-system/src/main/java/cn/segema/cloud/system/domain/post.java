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
@Table(name = "SYS_POST")
@Entity
public class post {
	@Id
	@Column(name = "POSTID")
	private BigInteger postId;
	
	@Column(name = "POSTNAME")
	private String postName;
	
	@Column(name = "POSTCODE")
	private String systemCode;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "DELETESTATUS")
	private Integer deletestatus;

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

	public Integer getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(Integer deletestatus) {
		this.deletestatus = deletestatus;
	}

}
