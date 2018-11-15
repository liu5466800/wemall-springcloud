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
@Table(name = "sys_user_resource")
@Entity
public class UserResource {
	@Id
	@Column(name = "user_resource_id")
	private BigInteger userResourceId;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "resource_id")
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
