package edu.vinaenter.dto;

import java.sql.Timestamp; 

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class ProductDto {
	private Integer id;
	private Integer cat_id;
	private String cat_name;
	
	@NotEmpty(message = "Nhap Ten San Pham")
	private String name;
	
//	@NotEmpty(message = "Nhap Gia Vao Kho")
	@NotNull(message ="Nhap Gia Vao Kho" )
	private Integer price_import;
	
//	@NotEmpty(message = "Nhap Gia Ban")
	@NotNull(message ="Nhap Gia Ban Ra" )
	private Integer price_new;
	
	private Integer price_old;
	
//	@NotEmpty(message = "Nhap So Luong San Pham")
	@NotNull(message ="Nhap So Luong Sản Pham" )
	private Integer amount;
	
	private String picture;
	
	@NotEmpty(message = "Nhap Mo Ta")
	private String preview;
	
	private Timestamp date_create;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCat_id() {
		return cat_id;
	}

	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public ProductDto(Integer id, Integer cat_id, String cat_name, @NotEmpty(message = "Nhap Ten San Pham") String name,
			Integer price_import, Integer price_new, Integer price_old, Integer amount, String picture,
			@NotEmpty(message = "Nhap Mo Ta") String preview, Timestamp date_create) {
		super();
		this.id = id;
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.name = name;
		this.price_import = price_import;
		this.price_new = price_new;
		this.price_old = price_old;
		this.amount = amount;
		this.picture = picture;
		this.preview = preview;
		this.date_create = date_create;
	}

	public ProductDto() {
		super();
	}
	

}
