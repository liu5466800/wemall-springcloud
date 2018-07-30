package cn.segema.cloud.system.vo;

import java.math.BigInteger;

/**
 * 用户人员信息
 * @author wangyong
 *
 */
public class UserPersonalVO {

	private BigInteger userId;

	private String userName;

	private String nickName;
	
	private BigInteger personalId;
	
	private String personalName;

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
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

	public UserPersonalVO(BigInteger userId, String userName, String nickName, BigInteger personalId, String personalName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.personalId = personalId;
		this.personalName = personalName;
	}

	
}
