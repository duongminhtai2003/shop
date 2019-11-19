package edu.vinaenter.dto;

import java.sql.Timestamp;  

import javax.validation.constraints.NotEmpty;

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
public class CategoryDto {
	private int id;
	@NotEmpty(message = "Nhap ten Danh Muc")
	private String name;
	private int parent_id;
	private String parent_name;
	private Timestamp date_create;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public CategoryDto(int id, @NotEmpty(message = "Nhap ten Danh Muc") String name, Integer parent_id,
			String parent_name, Timestamp date_create) {
		super();
		this.id = id;
		this.name = name;
		this.parent_id = parent_id;
		this.parent_name = parent_name;
		this.date_create = date_create;
	}
	public CategoryDto() {
		super();
	}
	
}
