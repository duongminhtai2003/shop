package edu.vinaenter.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.GiftCode;

@Repository
public class GiftCodeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public GiftCode findByName(String name) {
		final String sql = "select * from gift_code where name like ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {name},new BeanPropertyRowMapper<GiftCode>(GiftCode.class));
	}
	public int countgift(String name) {
		final String sql = "SELECT count(1) FROM gift_code where name like ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {name},Integer.class);
	}
	
}
