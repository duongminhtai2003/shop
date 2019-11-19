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
public class Parent_Cat {
	private int id;
	private String name;
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
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public Parent_Cat(int id, String name, Timestamp date_create) {
		super();
		this.id = id;
		this.name = name;
		this.date_create = date_create;
	}
	public Parent_Cat() {
		super();
	}
	
}
