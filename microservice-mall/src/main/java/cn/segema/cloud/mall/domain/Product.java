package cn.segema.cloud.mall.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品
 * @author wangyong
 */
@Table(name = "MALL_PRODUCT")
@Entity
public class Product implements Serializable{
	@Id
	@Column(name = "PRODUCTID")
	private BigInteger productId;

	@Column(name = "PRODUCTNAME")
	private String productName;
	
	@Column(name = "CATEGORYID")
	private BigInteger categoryId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "TEXT")
	private String text;

	@Column(name = "SUMMARY")
	private String summary;

	@Column(name = "THUMBNAIL")
	private String thumbnail;

	@Column(name = "PARENTID")
	private BigInteger parentId;

	@Column(name = "ORDERNUMBER")
	private int orderNumber;

	@Column(name = "STATUS")
	private int status;

	@Column(name = "BUYPRICE")
	private BigDecimal buyPrice;

	@Column(name = "SALEPRICE")
	private BigDecimal salePrice;

	@Column(name = "createtime")
	private LocalDateTime createtime;

	@Column(name = "REMARKS")
	private String remarks;

	public BigInteger getProductId() {
		return productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigInteger getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(BigInteger categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public BigInteger getParentId() {
		return parentId;
	}

	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
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

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public LocalDateTime getCreatetime() {
		return createtime;
	}

	public void setCreatetime(LocalDateTime createtime) {
		this.createtime = createtime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
