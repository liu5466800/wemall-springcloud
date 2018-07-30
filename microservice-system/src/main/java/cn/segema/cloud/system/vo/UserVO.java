package cn.segema.cloud.system.vo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 用户VO
 * @author wangyong
 *
 */
public class UserVO  implements Serializable{

	private static final long serialVersionUID = 3336026114894190728L;

	private BigInteger userId;
	
	private String userName;
	
	private String nickName;
	
	private String password;
	
	private String mobileNumber;
	
	private String credentialsSalt;

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
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

	public String getCredentialsSalt() {
		return credentialsSalt;
	}

	public void setCredentialsSalt(String credentialsSalt) {
		this.credentialsSalt = credentialsSalt;
	}

}
