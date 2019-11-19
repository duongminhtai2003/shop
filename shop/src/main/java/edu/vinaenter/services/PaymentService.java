package edu.vinaenter.services;

import java.util.List;

import edu.vinaenter.dto.CategoryDto;
import edu.vinaenter.models.Parent_Cat;
import edu.vinaenter.models.Payments;

public interface PaymentService {
	List<Payments> findAll();
	
	Payments getPaayment(int id);
		
	int add(Payments paymant);
	
	int delete(int id);
	
	int edit(Payments payments);

}
