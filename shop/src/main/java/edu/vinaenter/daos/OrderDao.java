package edu.vinaenter.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.dto.OrderDto;

@Repository
public class OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<OrderDto> findOrderByID(int id) {
		final String sql = "select orders.id,bill_id,products.name as product_name,products.price_new,products.price_import,products.picture,orders.amount from orders inner join products on orders.product_id = products.id where orders.bill_id=?";
		return jdbcTemplate.query(sql, new Object[] {id},new BeanPropertyRowMapper<OrderDto>(OrderDto.class));
	}

}
