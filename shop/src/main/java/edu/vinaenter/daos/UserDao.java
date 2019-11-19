package edu.vinaenter.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.constants.CommonConstants;
import edu.vinaenter.models.User;
import edu.vinaenter.utils.DefineUtil;
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}
	public int countUser() {// dem so user
		final String sql = "SELECT count(1) FROM users";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}

	public User getItem(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
	}

	public List<User> findUserByOffset(int offset) {
		final String sql = "SELECT * FROM users LIMIT ?,?";
		return jdbcTemplate.query(sql, new Object[] {offset,CommonConstants.DEFAULT_PAGING_SIZE},
				new BeanPropertyRowMapper<User>(User.class));
	}
	public int add(User user) {
		String sql = "INSERT INTO users(email,password,fullname,address,phone,active,role_id) value(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { user.getEmail(), user.getPassword(), user.getFullname(), user.getAddress(),user.getPhone(),user.getActive(),user.getRoleid()});
	}
	public User checkUsere(User user) {
		try {
			String sql = "SELECT * FROM users WHERE email = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] { user.getEmail()},
					new BeanPropertyRowMapper<User>(User.class));
		} catch (Exception e) {
			return null;
		}
	}
	
	public int del(int id) {
		String sql = "DELETE FROM users WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}
	public int edit(User user) {
		String sql = "UPDATE users SET password=?,fullname=?,address=?,phone=?,active=?,role_id=? WHERE id =?";
		return jdbcTemplate.update(sql, new Object[] {user.getPassword(), user.getFullname(),
				user.getAddress(),user.getPhone(),user.getActive(),user.getRoleid() ,user.getId() });
	}


}
