package cn.segema.cloud.wemall.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 地址
 * 
 * @author wangyong
 *
 */
@Table(name = "MALL_USER_ADDRESS")
@Entity
public class UserAddress {
	@Id
	@Column(name = "USERADDRESSID")
	private String useraddressid;

	@Column(name = "USERID")
	private String userid;

	@Column(name = "ADDRESSID")
	private String addressid;

	@Column(name = "CREATED")
	private String created;

}
