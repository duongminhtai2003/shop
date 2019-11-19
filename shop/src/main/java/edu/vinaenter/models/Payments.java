package edu.vinaenter.models;

import javax.validation.constraints.NotEmpty; 

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
public class Payments {
	private int id;
	@NotEmpty(message = "Không Được Để Trống")
	private String payment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Payments(int id, @NotEmpty(message = "Không Được Để Trống") String payment) {
		super();
		this.id = id;
		this.payment = payment;
	}
	public Payments() {
		super();
	}
	
	
}
