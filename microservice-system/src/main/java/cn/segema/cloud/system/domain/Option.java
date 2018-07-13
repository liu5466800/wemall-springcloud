package cn.segema.cloud.system.domain;

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
@Table(name = "SYS_OPTION")
@Entity
public class Option {
	@Id
	@Column(name = "OPTIONID")
	private String optionId;

	@Column(name = "OPTIONKEY")
	private String optionKey;

	@Column(name = "OPTIONVALUE")
	private String optionValue;

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
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

}
