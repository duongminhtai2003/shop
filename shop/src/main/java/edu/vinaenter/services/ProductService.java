package edu.vinaenter.services;

import java.util.List;

import edu.vinaenter.dto.ProductDto;
import edu.vinaenter.models.Products;

public interface ProductService {
	List<Products> findAll();
	List<ProductDto> findAllPagination(int offset);
	int countPagination();
	int addPrice(ProductDto products);
	int delete(Integer id);
	ProductDto getItem(Integer id);
	int edit(ProductDto products);
	boolean checkso(String st);
	List<ProductDto> findByCatId(Integer id);
}
