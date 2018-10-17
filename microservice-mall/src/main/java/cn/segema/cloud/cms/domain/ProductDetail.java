package cn.segema.cloud.cms.domain;

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
@Table(name = "CMS_PRODUCT_DETAIL")
@Entity
public class ProductDetail {
	@Id
	@Column(name = "PRODUCTDETAILID")
	private BigInteger productDetailId;

	@Column(name = "PRODUCTID")
	private BigInteger productId;

	@Column(name = "SPECIFICATIONID")
	private BigInteger specificationId;

	@Column(name = "VALUEID")
	private BigInteger valueId;

	@Column(name = "unit")
	private String unit;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "stock")
	private BigDecimal stock;

	@Column(name = "createtime")
	private LocalDateTime createTime;

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

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

}
