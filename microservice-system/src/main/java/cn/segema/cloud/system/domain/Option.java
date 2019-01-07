package cn.segema.cloud.system.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统参数
 * 
 * @author wangyong
 *
 */
@Table(name = "sys_option")
@Entity
public class Option {
	@Id
	@Column(name = "option_id")
	private BigInteger optionId;

	@Column(name = "option_key")
	private String optionKey;

	@Column(name = "option_value")
	private String optionValue;
	
	@Column(name = "delete_status")
	private Integer deleteStatus;
	
	@Column(name = "create_time")
	private BigInteger createTime;

	public BigInteger getOptionId() {
		return optionId;
	}

	public void setOptionId(BigInteger optionId) {
		this.optionId = optionId;
	}

	public String getOptionKey() {
		return optionKey;
	}

	public void setOptionKey(String optionKey) {
		this.optionKey = optionKey;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
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
