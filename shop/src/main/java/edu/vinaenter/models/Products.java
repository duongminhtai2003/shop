package edu.vinaenter.models;

import java.sql.Timestamp;

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

public class Products {
	private Integer id;
	private Category cat;
	private Integer price_import;
	private Integer price_new;
	private Integer price_old;
	private String name;
	private Integer amount;
	private String picture;
	private String preview;
	private Timestamp date_create;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Category getCat() {
		return cat;
	}
	public void setCat(Category cat) {
		this.cat = cat;
	}
	public Integer getPrice_import() {
		return price_import;
	}
	public void setPrice_import(Integer price_import) {
		this.price_import = price_import;
	}
	public Integer getPrice_new() {
		return price_new;
	}
	public void setPrice_new(Integer price_new) {
		this.price_new = price_new;
	}
	public Integer getPrice_old() {
		return price_old;
	}
	public void setPrice_old(Integer price_old) {
		this.price_old = price_old;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public Products() {
		super();
	}
	public Products(Integer id, Category cat, Integer price_import, Integer price_new, Integer price_old, String name,
			Integer amount, String picture, String preview, Timestamp date_create) {
		super();
		this.id = id;
		this.cat = cat;
		this.price_import = price_import;
		this.price_new = price_new;
		this.price_old = price_old;
		this.name = name;
		this.amount = amount;
		this.picture = picture;
		this.preview = preview;
		this.date_create = date_create;
	}
	
}
