package cn.segema.cloud.mall.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 产品详细
 * 
 * @author wangyong
 */
@Table(name = "mall_product_detail")
@Entity
public class ProductDetail {
	@Id
	@Column(name = "product_detail_id")
	private BigInteger productDetailId;

	@Column(name = "product_id")
	private BigInteger productId;

	@Column(name = "specification_id")
	private BigInteger specificationId;

	@Column(name = "value_id")
	private BigInteger valueId;

	@Column(name = "unit")
	private String unit;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "stock")
	private BigDecimal stock;
	
	@Column(name = "delete_status")
	private Integer deleteStatus;

	@Column(name = "create_time")
	private BigInteger createTime;

	public BigInteger getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(BigInteger productDetailId) {
		this.productDetailId = productDetailId;
	}

	public BigInteger getProductId() {
		return productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
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

	public BigDecimal getStock() {
		return stock;
	}

	public void setStock(BigDecimal stock) {
		this.stock = stock;
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
