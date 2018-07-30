package cn.segema.cloud.system.vo;

import java.math.BigInteger;
import java.util.List;

public class TreeVO {

	private BigInteger id;

	private String text;

	private List<TreeVO> children;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<TreeVO> getChildren() {
		return children;
	}

	public void setChildren(List<TreeVO> children) {
		this.children = children;
	}

	

}
