package edu.vinaenter.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.constants.CommonConstants;
import edu.vinaenter.dto.ProductDto;
import edu.vinaenter.models.Products;

@Repository
public class ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Products> findAll() {
		String sql = "SELECT * FROM products";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Products>(Products.class));
	}
	public List<ProductDto> findByCat(int id) {
		String sql = "SELECT * FROM products where cat_id=?";
		return jdbcTemplate.query(sql,new Object[] {id}, new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
	}
	
	public List<ProductDto> ListNew() {
		String sql = "SELECT * FROM products order by id desc limit 3 ";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
	}
	public List<ProductDto> ListSale() {
		String sql = "SELECT * FROM products where (products.price_new<=products.price_old/2) order by id desc limit 3 ";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
	}
	public List<ProductDto> ListSuggest() {
		String sql = "SELECT * FROM products where (products.price_new<products.price_old) limit 4";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
	}

	public int countProduct() {
		final String sql = "SELECT count(1) FROM products";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public ProductDto getItem(int id) {
		String sql = "SELECT * FROM products WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
	}

	public List<ProductDto> findPriceByOffset(int offset) {
		final String sql = "SELECT products.id,products.cat_id,categories.name as cat_name,price_import,price_new,price_old,products.name,amount,picture,"
				+ "preview,products.date_create FROM products inner join categories on products.cat_id=categories.id LIMIT ?,?";
		return jdbcTemplate.query(sql, new Object[] { offset, CommonConstants.DEFAULT_PAGING_SIZE },
				new BeanPropertyRowMapper<ProductDto>(ProductDto.class));
	}

	public int addProduct(ProductDto products) {
		String sql = "INSERT INTO products(cat_id,name,price_import,price_new,price_old,amount,picture,preview) value(?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {products.getCat_id(),products.getName(),products.getPrice_import(),products.getPrice_new(),
				products.getPrice_old(), products.getAmount(), products.getPicture(), products.getPreview() });
	}
	public int delProduct(int id) {
		String sql = "DELETE FROM products WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}
	public int edit(ProductDto products) {
		String sql = "UPDATE products SET cat_id=?,name=?,price_import=?,price_new=?,price_old=?,amount=?,picture=?,preview=? WHERE id =?";
		return jdbcTemplate.update(sql, new Object[] {products.getCat_id(),products.getName(),products.getPrice_import(),products.getPrice_new(),products.getPrice_old(),
			 products.getAmount(), products.getPicture(), products.getPreview(),products.getId()});
	}

}
