package edu.vinaenter.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.daos.CategoryDao;
import edu.vinaenter.daos.PaymentDao;
import edu.vinaenter.models.Payments;
import edu.vinaenter.services.PaymentService;


@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentDao paymentDao;


	public List<Payments> findAll() {
		return paymentDao.listpayment();
	}


	public Payments getPaayment(int id) {
		return paymentDao.getPayment(id);
	}


	public int add(Payments payments) {
		return paymentDao.add(payments);
	}


	public int delete(int id) {
		return paymentDao.del(id);
	}


	public int edit(Payments payments) {
		return paymentDao.edit(payments);
	}	
	
	
}
