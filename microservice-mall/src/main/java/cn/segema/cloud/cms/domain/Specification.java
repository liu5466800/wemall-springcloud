package cn.segema.cloud.cms.domain;

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
@Table(name = "CMS_SPECIFICATION")
@Entity
public class Specification {
	@Id
	@Column(name = "SPECIFICATIONID")
	private BigInteger specificationId;

	@Column(name = "SPECIFICATIONNAME")
	private String specificationname;

	@Column(name = "ORDERNUMBER")
	private int orderNumber;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "STATUS")
	private int status;

	@Column(name = "createtime")
	private LocalDateTime createTime;

	public BigInteger getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(BigInteger specificationId) {
		this.specificationId = specificationId;
	}

	public String getSpecificationname() {
		return specificationname;
	}

	public void setSpecificationname(String specificationname) {
		this.specificationname = specificationname;
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

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

}
