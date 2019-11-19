package edu.vinaenter.services.impls;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

import edu.vinaenter.daos.ProductDao;
import edu.vinaenter.dto.ProductDto;
import edu.vinaenter.models.Products;
import edu.vinaenter.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	public List<Products> findAll() {
		return  productDao.findAll();
	}

	public List<ProductDto> findAllPagination(int offset) {
		List<ProductDto> listproduct = productDao.findPriceByOffset(offset);
		for (ProductDto productDto : listproduct) {
			String preview = productDto.getPreview();
			productDto.setPreview(productDto.getPreview().substring(0,40));
		}
		return listproduct;
	}

	public int countPagination() {
		return productDao.countProduct();
	}

	public int addPrice(ProductDto products) {
		return productDao.addProduct(products);
	}

	public int delete(Integer id) {
		return productDao.delProduct(id);
	}

	public ProductDto getItem(Integer id) {
		return productDao.getItem(id);
	}

	public int edit(ProductDto products) {
		return productDao.edit(products);
	}

	public boolean checkso(String st) {
		 for (int i = 0; i < st.length(); i++) {
	            if (Character.isLetter(st.charAt(i))) {
	                return true;
	            }
	            if (i + 1 == st.length()) {
	                return false;
	            }
	        }
		 return false;
	}

	public List<ProductDto> findByCatId(Integer id) {
		// TODO Auto-generated method stub
		return productDao.findByCat(id);
	}

}
