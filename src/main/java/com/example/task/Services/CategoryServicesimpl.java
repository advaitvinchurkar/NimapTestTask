package com.example.task.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.Entity.Category;
import com.example.task.Entity.CategoryResponce;
import com.example.task.Entity.PaginatedResponse;
import com.example.task.Exception.InvalidRequestException;
import com.example.task.Exception.ResourceNotFoundException;
import com.example.task.Repository.CategoryRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CategoryServicesimpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category insertcategory(Category c) {
		
		return categoryRepository.save(c);
	}

	@Override
	public List<Category> getAllCategory() {
		
		List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new ResourceNotFoundException("No categories found.");
        }
        return categories;
		
		
	}

	@Override
	public Category findByCategoryId(long catrgory_id) {
		
		return categoryRepository.findById(catrgory_id).orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + catrgory_id));

	}

	@Override
	public void deleteByCategoryId(long category_id) {
		
		 if (!categoryRepository.existsById(category_id)) {
	            throw new ResourceNotFoundException("Category not found with ID: " + category_id);
	        }
		 categoryRepository.deleteById(category_id);
		
		//cr.deleteById(category_id);
		
	}

	@Override
	public Category updateByCategoryId(long catrgory_id, Category categoryinfo) {
		
		 Category category = categoryRepository.findById(catrgory_id)
	                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + catrgory_id));

		 
		 if (categoryinfo.getCategory_name() == null || categoryinfo.getCategory_name().isEmpty()) {
	            throw new InvalidRequestException("Category name cannot be empty.");
	        }
		
		category.setCategory_name(categoryinfo.getCategory_name());
		category.setCategory_description(categoryinfo.getCategory_description());
		return categoryRepository.save(category);
	}
	
	 public PaginatedResponse<CategoryResponce> getPaginatedCategories(int page, int size,List<CategoryResponce> categories) {
	        int totalItems = categories.size();
	        int start = Math.min(page * size, totalItems);
	        int end = Math.min(start + size, totalItems);

	        List<CategoryResponce> paginatedCategories = categories.subList(start, end);
	        int totalPages = (int) Math.ceil((double) totalItems / size);

	        return new PaginatedResponse<>(paginatedCategories, page, totalPages, totalItems);
	    }


	

}
