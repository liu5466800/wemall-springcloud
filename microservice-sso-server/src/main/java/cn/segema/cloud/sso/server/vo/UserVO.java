package cn.segema.cloud.sso.server.vo;

import java.io.Serializable;
import java.util.List;

public class UserVO implements Serializable {

	private Long id;

	/**
	 * 用户编号
	 */
	private String usercode;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 盐
	 */
	private String salt;

	/**
	 * 用户角色
	 */
	private List<RoleVO> roleList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public List<RoleVO> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleVO> roleList) {
		this.roleList = roleList;
	}

	public UserVO(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
