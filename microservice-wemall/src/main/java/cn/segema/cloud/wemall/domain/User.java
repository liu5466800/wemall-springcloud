package cn.segema.cloud.wemall.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 微信用户
 * @author wangyong
 */
@Table(name = "MALL_USER")
@Entity
public class User {
	@Id
	@Column(name = "USERID")
	private long userId;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "NICKNAME")
	private String nickName;

	@Column(name = "REALNAME")
	private String realName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "SALT")
	private String salt;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "GENDER")
	private Integer gender;

	@Column(name = "SIGNATURE")
	private Integer signature;

	@Column(name = "QQ")
	private String qq;

	@Column(name = "BIRTHDAY")
	private LocalDateTime birthday;

	@Column(name = "AVATAR")
	private String avatar;

	@Column(name = "IDCARDTYPE")
	private String idcardtype;

	@Column(name = "IDCARD")
	private String idcard;

	@Column(name = "CREATED")
	private LocalDateTime created;

	@Column(name = "OPENID")
	private String openId;

	@Column(name = "PID")
	private String pId;

	@Column(name = "STATUS")
	private Integer status;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getSignature() {
		return signature;
	}

	public void setSignature(Integer signature) {
		this.signature = signature;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIdcardtype() {
		return idcardtype;
	}

	public void setIdcardtype(String idcardtype) {
		this.idcardtype = idcardtype;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
