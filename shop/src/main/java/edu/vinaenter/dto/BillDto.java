package edu.vinaenter.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillDto {
	private int id;
	private Integer user_id;
	private String email;
	private String fullname;
	private String address;
	private String phone;
	private String status;
	private Integer total_money;
	private Integer payment_id;
	private String payment;
	private Timestamp date_create;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTotal_money() {
		return total_money;
	}
	public void setTotal_money(Integer total_money) {
		this.total_money = total_money;
	}
	public Integer getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public BillDto(int id, Integer user_id, String email, String fullname, String address, String phone, String status,
			Integer total_money, Integer payment_id, String payment, Timestamp date_create) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.email = email;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.total_money = total_money;
		this.payment_id = payment_id;
		this.payment = payment;
		this.date_create = date_create;
	}
	public BillDto() {
		super();
	}
	
	
}
