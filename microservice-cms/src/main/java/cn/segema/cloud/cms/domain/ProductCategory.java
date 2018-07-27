package cn.segema.cloud.cms.domain;

import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品分类
 * 
 * @author wangyong
 */
@Table(name = "CMS_PRODUCT_CATEGORY")
@Entity
public class ProductCategory {
	@Id
	@Column(name = "CATEGORYID")
	private BigInteger categoryId;

	@Column(name = "CATEGORYNAME")
	private String categoryName;

	@Column(name = "TEXT")
	private String text;

	@Column(name = "icon")
	private String icon;

	@Column(name = "ORDERNUMBER")
	private int orderNumber;

	@Column(name = "PARENTID")
	private BigInteger parentId;

	@Column(name = "STATUS")
	private int status;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "createtime")
	private LocalDateTime createTime;

	public BigInteger getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(BigInteger categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigInteger getParentId() {
		return parentId;
	}

	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

}
