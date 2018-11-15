package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 子系统
 * @author wangyong
 *
 */
@Table(name = "sys_system")
@Entity
public class System {
	@Id
	@Column(name = "system_id")
	private BigInteger systemId;
	
	@Column(name = "system_name")
	private String systemName;
	
	@Column(name = "system_code")
	private String systemCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "delete_status")
	private Integer deletestatus;

	public BigInteger getSystemId() {
		return systemId;
	}

	public void setSystemId(BigInteger systemId) {
		this.systemId = systemId;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(Integer deletestatus) {
		this.deletestatus = deletestatus;
	}

	

}
