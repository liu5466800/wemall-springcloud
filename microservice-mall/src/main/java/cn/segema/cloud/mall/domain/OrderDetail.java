package cn.segema.cloud.mall.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订单明细
 * 
 * @author wangyong
 */
@Table(name = "mall_order_detail")
@Entity
public class OrderDetail {
	@Id
	@Column(name = "order_detail_id")
	private BigInteger orderDetailId;

	@Column(name = "order_id")
	private BigInteger orderId;

	@Column(name = "specification_id")
	private BigInteger specificationId;

	@Column(name = "value_id")
	private BigInteger valueId;

	@Column(name = "unit")
	private String unit;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "money")
	private BigDecimal money;

	public BigInteger getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(BigInteger orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public BigInteger getOrderId() {
		return orderId;
	}

	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	public BigInteger getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(BigInteger specificationId) {
		this.specificationId = specificationId;
	}

	public BigInteger getValueId() {
		return valueId;
	}

	public void setValueId(BigInteger valueId) {
		this.valueId = valueId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

}
