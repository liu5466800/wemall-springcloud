package cn.segema.cloud.mall.domain;

import java.math.BigInteger;

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
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "birthday")
	private BigInteger birthday;

	@Column(name = "real_name")
	private String realName;

	@Column(name = "nick_name")
	private String nickName;

	@Column(name = "password")
	private String password;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "salt")
	private String salt;

	@Column(name = "gender")
	private Integer gender;
	
	@Column(name = "email")
	private String email;

	@Column(name = "idcard")
	private String idcard;

	@Column(name = "idcard_type")
	private Integer idcardType;

	@Column(name = "openid")
	private String openid;

	@Column(name = "parent_id")
	private String parentId;

	@Column(name = "qq")
	private String qq;

	@Column(name = "signature")
	private String signature;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "delete_status")
	private Integer deleteStatus;
	
	@Column(name = "create_time")
	private BigInteger createTime;

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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public BigInteger getBirthday() {
		return birthday;
	}

	public void setBirthday(BigInteger birthday) {
		this.birthday = birthday;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
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

	public Integer getIdcardType() {
		return idcardType;
	}

	public void setIdcardType(Integer idcardType) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
