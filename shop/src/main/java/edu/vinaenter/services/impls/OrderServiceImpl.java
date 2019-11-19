package edu.vinaenter.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.daos.OrderDao;
import edu.vinaenter.dto.OrderDto;
import edu.vinaenter.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;


	public List<OrderDto> findByID(int id) {
		return orderDao.findOrderByID(id);
	}
	
	
}
