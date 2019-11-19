package edu.vinaenter.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.constants.CommonConstants;
import edu.vinaenter.dto.BillDto;
import edu.vinaenter.models.User;

@Repository
public class BillDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<BillDto> findUserByOffset(int offset) {
		final String sql = "SELECT bill.id,users.id as user_id,users.email,users.fullname,users.address,"
				+ "users.phone,bill.status,bill.total_money,payments.id as payment_id,"
				+ "payments.payment,bill.date_create from users inner join bill on users.id = bill.user_id inner join payments on"
				+ " bill.payment_id = payments.id LIMIT ?,?";
		return jdbcTemplate.query(sql, new Object[] {offset,CommonConstants.DEFAULT_PAGING_SIZE},
				new BeanPropertyRowMapper<BillDto>(BillDto.class));
	}
	public int countUser() {
		final String sql = "SELECT count(1) FROM bill";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}
	public BillDto getItem(int id) {
		String sql = "SELECT bill.id,users.id as user_id,users.email,users.fullname,users.address,"
				+ "users.phone,bill.status,bill.total_money,payments.id as payment_id,"
				+ "payments.payment,bill.date_create from users inner join bill on users.id = bill.user_id inner join payments on"
				+ " bill.payment_id = payments.id where bill.id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<BillDto>(BillDto.class));
	}
	public int del(int id) {
		String sql = "DELETE FROM bill WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}
	public int edit(BillDto billDto) {
		String sql = "UPDATE bill SET status=? WHERE id =?";
		return jdbcTemplate.update(sql, new Object[] {billDto.getStatus(),billDto.getId()});
	}
	
	
}
