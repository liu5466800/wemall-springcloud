package cn.segema.cloud.demo.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户
 * @author wangyong
 */
@Table(name = "DEMO_TIME")
@Entity
public class DemoTime {
	@Id
	@Column(name = "userid")
	private String userId;

	@Column(name = "username")
	private String userName;

	@Column(name = "nickname")
	private String nickName;

	@Column(name = "password")
	private String password;

	@Column(name = "mobilenumber")
	private String mobileNumber;

	@Column(name = "create_time")
	private BigInteger createTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public BigInteger getCreateTime() {
		return createTime;
	}

	public void setCreateTime(BigInteger createTime) {
		this.createTime = createTime;
	}

}
