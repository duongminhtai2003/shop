package edu.vinaenter.models;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
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
public class User {

		private Integer id;
		
		@NotEmpty(message = "KhÃ´ng Bá»� Trá»‘ng Email")
//		@Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$",message = "Ä�á»‹nh Dáº¡ng Sai Email: abc@gmail.com")
		@Email(message ="Ä�á»‹nh Dáº¡ng Sai Email: abc@gmail.com" )
		private String email;
		
		@NotEmpty(message = "KhÃ´ng Bá»� Trá»‘ng password")
		private String password;
		
		@NotEmpty(message = "KhÃ´ng Bá»� Trá»‘ng fullname")
		private String fullname;
		
		@NotEmpty(message = "KhÃ´ng Bá»� Trá»‘ng address")
		private String address;
		
		@NotEmpty(message = "KhÃ´ng Bá»� Trá»‘ng phone")
		private String phone;

		private Integer active;
		
		
		private Integer roleid;
		
		
		private Integer otp;
		
		private Timestamp date_create;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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

		public Integer getActive() {
			return active;
		}

		public void setActive(Integer active) {
			this.active = active;
		}

		public Integer getRoleid() {
			return roleid;
		}

		public void setRoleid(Integer roleid) {
			this.roleid = roleid;
		}

		public Integer getOtp() {
			return otp;
		}

		public void setOtp(Integer otp) {
			this.otp = otp;
		}

		public Timestamp getDate_create() {
			return date_create;
		}

		public void setDate_create(Timestamp date_create) {
			this.date_create = date_create;
		}
		public User(Integer id,
				@NotEmpty(message = "KhÃ´ng Bá»� Trá»‘ng Email") @Email(message = "Ä�á»‹nh Dáº¡ng Sai Email: abc@gmail.com") String email,
				@NotEmpty(message = "KhÃ´ng Bá»� Trá»‘ng password") String password,
				@NotEmpty(message = "KhÃ´ng Bá»� Trá»‘ng fullname") String fullname,
				@NotEmpty(message = "KhÃ´ng Bá»� Trá»‘ng address") String address,
				@NotEmpty(message = "KhÃ´ng Bá»� Trá»‘ng phone") String phone, Integer active, Integer roleid, Integer otp,
				Timestamp date_create) {
			super();
			this.id = id;
			this.email = email;
			this.password = password;
			this.fullname = fullname;
			this.address = address;
			this.phone = phone;
			this.active = active;
			this.roleid = roleid;
			this.otp = otp;
			this.date_create = date_create;
		}

		public User() {
			super();
		}
		
		
		
}
