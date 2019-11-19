package edu.vinaenter.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.dto.CategoryDto;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Parent_Cat;
import edu.vinaenter.models.User;

@Repository
public class CategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Parent_Cat> listparent(){
		String sql = "select * from parent_cat";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Parent_Cat>(Parent_Cat.class));
	}
	public Parent_Cat getParent(int id) {
		String sql = "select * from parent_cat where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[] {id},new BeanPropertyRowMapper<Parent_Cat>(Parent_Cat.class));
	}
	public int dellan(int catid) {
		String sql ="DELETE FROM lands WHERE cid = ?";
		return jdbcTemplate.update(sql,new Object[] {catid});
		
	}
	public List<CategoryDto> findAll() {
		String sql = "select categories.id,categories.name,parent_cat.id as parent_id,parent_cat.name as parent_name,"
				+ "categories.date_create from categories inner join parent_cat on categories.parent_id = parent_cat.id";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<CategoryDto>(CategoryDto.class));
	}
	
	public int add(CategoryDto cat) {
		String sql = "INSERT INTO categories(name,parent_id) VALUE(?,?)";
		return jdbcTemplate.update(sql,new Object[] {cat.getName(),cat.getParent_id()});
	}
	
	public int del(int id) {
		String sql ="DELETE FROM categories WHERE id = ?";
		return jdbcTemplate.update(sql,new Object[] {id});
	}
	
	public CategoryDto getItem(int id) {
		String sql = "select categories.id,categories.name,parent_cat.id as parent_id,parent_cat.name as parent_name,"
				+ "categories.date_create from categories inner join parent_cat on categories.parent_id = parent_cat.id where categories.id=?";
		return  jdbcTemplate.queryForObject(sql,new Object[] {id},new BeanPropertyRowMapper<CategoryDto>(CategoryDto.class));
	}
	
	public int edit(CategoryDto cat) {
		String sql = "UPDATE categories set name= ?, parent_id = ? WHERE id =?";
		return jdbcTemplate.update(sql,new Object[] {cat.getName(),cat.getParent_id(),cat.getId()});
	}
	public CategoryDto checkCate(CategoryDto category) {
		try {
			String sql = "SELECT * FROM categories WHERE name = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] {category.getName()},
					new BeanPropertyRowMapper<CategoryDto>(CategoryDto.class));
		} catch (Exception e) {
			return null;
		}
	}

}
