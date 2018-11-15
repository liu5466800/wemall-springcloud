package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 用户人员关系
 * @author wangyong
 *
 */
@Table(name = "sys_user_personal")
@Entity
public class UserPersonal {
	@Id
	@Column(name = "user_personal_id")
	private BigInteger userPersonalId;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "personal_id")
	private Personal personal;

	public BigInteger getUserPersonalId() {
		return userPersonalId;
	}

	public void setUserPersonalId(BigInteger userPersonalId) {
		this.userPersonalId = userPersonalId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

}
