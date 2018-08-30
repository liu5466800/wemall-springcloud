package cn.segema.cloud.demo.vo;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "goods",type = "book") 
public class GoodsVO  implements Serializable{
	private Integer id;
	private String name;
	private String anthony;
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnthony() {
		return anthony;
	}

	public void setAnthony(String anthony) {
		this.anthony = anthony;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GoodsVO(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public GoodsVO() {
	}
}
