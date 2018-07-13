package cn.segema.cloud.wemall.order.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订单
 * 
 * @author wangyong
 *
 */
@Table(name = "MALL_ORDER")
@Entity
public class Order {
	@Id
	@Column(name = "ORDERID")
	private long orderId;

	@Column(name = "ORDERNAME")
	private String orderName;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

}
