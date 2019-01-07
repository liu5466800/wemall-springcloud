package cn.segema.cloud.mall.domain;

import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 规格
 * 
 * @author wangyong
 */
@Table(name = "mall_specification")
@Entity
public class Specification {
	@Id
	@Column(name = "specification_id")
	private BigInteger specificationId;

	@Column(name = "specification_name")
	private String specificationName;

	@Column(name = "order_number")
	private int orderNumber;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "status")
	private int status;

	@Column(name = "delete_status")
	private Integer deleteStatus;

	@Column(name = "create_time")
	private BigInteger createTime;

	public BigInteger getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(BigInteger specificationId) {
		this.specificationId = specificationId;
	}

	public String getSpecificationName() {
		return specificationName;
	}

	public void setSpecificationName(String specificationName) {
		this.specificationName = specificationName;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
