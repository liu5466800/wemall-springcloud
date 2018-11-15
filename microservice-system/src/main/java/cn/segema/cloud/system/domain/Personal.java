package cn.segema.cloud.system.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 人员
 * @author wangyong
 *
 */
@Table(name = "sys_personal")
@Entity
public class Personal {
	@Id
	@Column(name = "personal_id")
	private BigInteger personalId;
	
	@Column(name = "personal_name")
	private String personalName;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "born_address_id")
	private String bornAddressId;
	
	@Column(name = "born_time")
	private LocalDateTime bornTime;
	
	@Column(name = "weight")
	private BigDecimal weight;
	
	@Column(name = "height")
	private BigDecimal height;
	
	@Column(name = "blood_type")
	private BigDecimal bloodType;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "home_address_id")
	private String homeAddressId;
	
	@Column(name = "group_id")
	private String groupId;
	
	@Column(name = "nation")
	private String nation;
	
	@Column(name = "identity_number")
	private String identityNumber;
	
	@Column(name = "create_time")
	private LocalDateTime createTime;


	public BigInteger getPersonalId() {
		return personalId;
	}

	public void setPersonalId(BigInteger personalId) {
		this.personalId = personalId;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBornAddressId() {
		return bornAddressId;
	}

	public void setBornAddressId(String bornAddressId) {
		this.bornAddressId = bornAddressId;
	}

	public LocalDateTime getBornTime() {
		return bornTime;
	}

	public void setBornTime(LocalDateTime bornTime) {
		this.bornTime = bornTime;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getBloodType() {
		return bloodType;
	}

	public void setBloodType(BigDecimal bloodType) {
		this.bloodType = bloodType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeAddressId() {
		return homeAddressId;
	}

	public void setHomeAddressId(String homeAddressId) {
		this.homeAddressId = homeAddressId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

}
