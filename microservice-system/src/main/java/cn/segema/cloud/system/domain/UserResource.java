package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户-资源关系
 * @author wangyong
 *
 */
@Table(name = "SYS_USER_RESOURCE")
@Entity
public class UserResource {
	@Id
	@Column(name = "USERRESOURCEID")
	private BigInteger userResourceId;

	@OneToOne
	@JoinColumn(name = "USERID")
	private User user;

	@OneToOne
	@JoinColumn(name = "RESOURCEID")
	private Resource resource;

	public BigInteger getUserResourceId() {
		return userResourceId;
	}

	public void setUserResourceId(BigInteger userResourceId) {
		this.userResourceId = userResourceId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}
