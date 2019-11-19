package edu.vinaenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
	private int id;
	private Integer bill_id;
	private String product_name;
	private Integer price_new;
	private Integer price_import;
	private Integer sum;
	private String picture;
	private Integer amount;
	public int getId() {
		return id;
	}
	
	public OrderDto(int id, Integer bill_id, String product_name, Integer price_new, Integer price_import, Integer sum,
			String picture, Integer amount) {
		super();
		this.id = id;
		this.bill_id = bill_id;
		this.product_name = product_name;
		this.price_new = price_new;
		this.price_import = price_import;
		this.sum = sum;
		this.picture = picture;
		this.amount = amount;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Integer getBill_id() {
		return bill_id;
	}
	public void setBill_id(Integer bill_id) {
		this.bill_id = bill_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Integer getPrice_new() {
		return price_new;
	}
	public void setPrice_new(Integer price_new) {
		this.price_new = price_new;
	}
	public Integer getPrice_import() {
		return price_import;
	}
	public void setPrice_import(Integer price_import) {
		this.price_import = price_import;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public OrderDto(int id, Integer bill_id, String product_name, Integer price_new, Integer price_import,
			String picture, Integer amount) {
		super();
		this.id = id;
		this.bill_id = bill_id;
		this.product_name = product_name;
		this.price_new = price_new;
		this.price_import = price_import;
		this.picture = picture;
		this.amount = amount;
	}
	public OrderDto() {
		super();
	}
	
	
}
