package edu.vinaenter.services;

import java.util.List;

import edu.vinaenter.dto.CategoryDto;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Parent_Cat;

public interface CategoryServices {
	List<CategoryDto> findAll();
	
	Parent_Cat getParent(int id);
	
	List<Parent_Cat> listParent();
	
	int add(CategoryDto cat);
	
	int delete(int id);
	
	CategoryDto getItem(int id);
	
	int edit(CategoryDto category);
	
	int delland(int catid);
	
	CategoryDto checkCate(CategoryDto category);
}
