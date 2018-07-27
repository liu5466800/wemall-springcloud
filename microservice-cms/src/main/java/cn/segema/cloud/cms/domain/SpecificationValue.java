package cn.segema.cloud.cms.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 规格值
 * 
 * @author wangyong
 */
@Table(name = "CMS_SPECIFICATION_VALUE")
@Entity
public class SpecificationValue {
	@Id
	@Column(name = "VALUEID")
	private BigInteger valueId;

	@Column(name = "SPECIFICATIONID")
	private BigInteger specificationId;

	@Column(name = "VALUE")
	private BigDecimal value;
	
	@Column(name = "unit")
	private String unit;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "ORDERNUMBER")
	private int orderNumber;

	@Column(name = "STATUS")
	private int status;

	@Column(name = "createtime")
	private LocalDateTime createTime;

	public BigInteger getValueId() {
		return valueId;
	}

	public void setValueId(BigInteger valueId) {
		this.valueId = valueId;
	}

	public BigInteger getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(BigInteger specificationId) {
		this.specificationId = specificationId;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

}
