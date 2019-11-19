package edu.vinaenter.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Payments;

@Repository
public class PaymentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Payments> listpayment(){
		String sql = "select * from payments";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Payments>(Payments.class));
	}
	public Payments getPayment(int id) {
		String sql = "select * from payments where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[] {id},new BeanPropertyRowMapper<Payments>(Payments.class));
	}
	public int del(int id) {
		String sql ="DELETE FROM payments WHERE id = ?";
		return jdbcTemplate.update(sql,new Object[] {id});
		
	}	
	public int add(Payments payments) {
		String sql = "INSERT INTO payments(payment) VALUE(?)";
		return jdbcTemplate.update(sql,new Object[] {payments.getPayment()});
	}
	public int edit(Payments payments) {
		String sql = "UPDATE payments set payment= ?WHERE id =?";
		return jdbcTemplate.update(sql,new Object[] {payments.getPayment(),payments.getId()});
	}
}
