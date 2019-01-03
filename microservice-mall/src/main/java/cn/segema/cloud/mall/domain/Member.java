package cn.segema.cloud.mall.domain;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 会员
 * 
 * @author wangyong
 *
 */
@Table(name = "mall_member")
@Entity
public class Member {
	@Id
	@Column(name = "member_id")
	private BigInteger memberId;

	@Column(name = "member_name")
	private String memberName;

	@Column(name = "real_name")
	private String realName;

	@Column(name = "nick_name")
	private String nickName;

	@Column(name = "password")
	private String password;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "credentials_salt")
	private String credentialsSalt;

	@Column(name = "gender")
	private Integer gender;

	@Column(name = "delete_status")
	private Integer deletestatus;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "birthday")
	private LocalDateTime birthday;

	@Column(name = "create_time")
	private LocalDateTime createTime;

	@Column(name = "email")
	private String email;

	@Column(name = "idcard")
	private String idcard;

	@Column(name = "idcard_type")
	private String idcardType;

	@Column(name = "openid")
	private String openid;

	@Column(name = "parent_id")
	private String parentId;

	@Column(name = "qq")
	private String qq;

	@Column(name = "signature")
	private String signature;

	public BigInteger getMemberId() {
		return memberId;
	}

	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public String getCredentialsSalt() {
		return credentialsSalt;
	}

	public void setCredentialsSalt(String credentialsSalt) {
		this.credentialsSalt = credentialsSalt;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(Integer deletestatus) {
		this.deletestatus = deletestatus;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIdcardType() {
		return idcardType;
	}

	public void setIdcardType(String idcardType) {
		this.idcardType = idcardType;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
