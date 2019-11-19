package edu.vinaenter.models;

import javax.persistence.Id;   
import javax.persistence.Table;

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
public class Category {
	
	private int id;
	@NotEmpty(message = "Nhap ten Danh Muc")
	private String name;
	private Parent_Cat parent_Cat;
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
	public Parent_Cat getParent_Cat() {
		return parent_Cat;
	}
	public void setParent_Cat(Parent_Cat parent_Cat) {
		this.parent_Cat = parent_Cat;
	}
	public Category(int id, @NotEmpty(message = "Nhap ten Danh Muc") String name, Parent_Cat parent_Cat) {
		super();
		this.id = id;
		this.name = name;
		this.parent_Cat = parent_Cat;
	}
	public Category() {
		super();
	}
	
	
}
