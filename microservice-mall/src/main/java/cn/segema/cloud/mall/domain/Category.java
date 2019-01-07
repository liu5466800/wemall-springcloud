package cn.segema.cloud.mall.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品分类
 * 
 * @author wangyong
 */
@Table(name = "mall_category")
@Entity
public class Category {
	@Id
	@Column(name = "category_id")
	private BigInteger categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "text")
	private String text;

	@Column(name = "icon")
	private String icon;

	@Column(name = "order_number")
	private int orderNumber;

	@Column(name = "parent_id")
	private BigInteger parentId;

	@Column(name = "status")
	private int status;

	@Column(name = "description")
	private String description;
	
	@Column(name = "delete_status")
	private Integer deleteStatus;

	@Column(name = "create_time")
	private BigInteger createTime;

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
