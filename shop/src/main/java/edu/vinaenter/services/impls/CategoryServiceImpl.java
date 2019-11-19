package edu.vinaenter.services.impls;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.daos.CategoryDao;
import edu.vinaenter.dto.CategoryDto;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Parent_Cat;
import edu.vinaenter.services.CategoryServices;


@Service
public class CategoryServiceImpl implements CategoryServices {
	@Autowired
	private CategoryDao catDao;

	public List<CategoryDto> findAll() {
		return catDao.findAll();
	}

	public int add(CategoryDto cat) {
		return catDao.add(cat);
	}


	public int delete(int id) {
		return catDao.del(id);
		
	}


	public CategoryDto getItem(int id) {
		return catDao.getItem(id);
	}


	public int edit(CategoryDto category) {
		return catDao.edit(category);
	}


	public int delland(int catid) {
		
		return catDao.dellan(catid);
	}

	public CategoryDto checkCate(CategoryDto category) {
		// TODO Auto-generated method stub
		return catDao.checkCate(category);
	}

	public List<Parent_Cat> listParent() {
		return catDao.listparent();
	}

	public Parent_Cat getParent(int id) {

		return catDao.getParent(id);
	}

	
	
	
}
