package cn.segema.cloud.demo.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document(indexName = "cars",type = "transactions",shards = 1, replicas = 0,refreshInterval = "-1") 
public class CarsTransactionsVO  implements Serializable{
	private static final long serialVersionUID = 859452469559974554L;
	private String id;
	private Integer price;
	private String color;
	private String make;
	//@JsonSerialize(using = LocalDateTimeSerializer.class)
	//@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
	private LocalDateTime sold;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public LocalDateTime getSold() {
		return sold;
	}
	public void setSold(LocalDateTime sold) {
		this.sold = sold;
	}

	
}
