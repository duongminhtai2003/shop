package edu.vinaenter.services;

import java.util.List;

import edu.vinaenter.dto.OrderDto;

public interface OrderService {
	List<OrderDto> findByID(int id);
}
