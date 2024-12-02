package com.example.task.Services;

import java.util.List;

import com.example.task.Entity.Category;
import com.example.task.Entity.CategoryResponce;
import com.example.task.Entity.PaginatedResponse;

public interface CategoryService {
	
	public Category insertcategory(Category c);
	
	List<Category> getAllCategory();
	
	Category findByCategoryId(long catrgory_id);

	void deleteByCategoryId(long category_id);
	
	Category updateByCategoryId(long catrgory_id,Category categoryinfo);
	
	  PaginatedResponse<CategoryResponce> getPaginatedCategories(int page, int size,List<CategoryResponce> categories) ;


}
