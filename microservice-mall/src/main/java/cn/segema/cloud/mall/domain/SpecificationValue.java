package cn.segema.cloud.mall.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 规格值
 * 
 * @author wangyong
 */
@Table(name = "mall_specification_value")
@Entity
public class SpecificationValue {
	@Id
	@Column(name = "value_id")
	private BigInteger valueId;

	@Column(name = "specification_id")
	private BigInteger specificationId;

	@Column(name = "value")
	private BigDecimal value;
	
	@Column(name = "unit")
	private String unit;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "order_number")
	private Integer orderNumber;

	@Column(name = "status")
	private Integer status;
	
	@Column(name = "delete_status")
	private Integer deleteStatus;

	@Column(name = "create_time")
	private BigInteger createTime;

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
