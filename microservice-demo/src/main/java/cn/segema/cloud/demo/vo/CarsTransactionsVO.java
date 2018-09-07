package cn.segema.cloud.demo.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "cars",type = "transactions") 
public class CarsTransactionsVO  implements Serializable{
	private Integer price;
	private String color;
	private String make;
	private Date sold;
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public Date getSold() {
		return sold;
	}
	public void setSold(Date sold) {
		this.sold = sold;
	}

	
}
