package cn.segema.cloud.mall.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订单
 * 
 * @author wangyong
 */
@Table(name = "mall_order")
@Entity
public class Order {
	@Id
	@Column(name = "order_id")
	private BigInteger orderId;

	@Column(name = "order_name")
	private String orderName;

	@Column(name = "order_code")
	private String orderCode;


	@Column(name = "status")
	private int status;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "create_time")
	private LocalDateTime createTime;

	@Column(name = "order_money")
	private BigDecimal orderMoney;

	public BigInteger getOrderId() {
		return orderId;
	}

	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}
	
}
