package com.example.task.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.Entity.Category;
import com.example.task.Entity.CategoryResponce;
import com.example.task.Entity.PaginatedResponse;
import com.example.task.Entity.ProductResponse;
import com.example.task.Services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/")
	public Category  createcategosy(@RequestBody Category c) {
		
		return categoryService.insertcategory(c);
		
	}
	
	
	@GetMapping("/")
	public PaginatedResponse<CategoryResponce>  getAllCategory( @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size   ) {
		
		
		
		return categoryService.getPaginatedCategories(page, size,  categoryService.getAllCategory().stream()
				 .map(category -> new CategoryResponce(
						
						 category.getCategoryId(),
						 category.getCategory_name(),
						 category.getCategory_description()
			            ))
			            .collect(Collectors.toList()));
	}
	
	@GetMapping("/{id}")
	public CategoryResponce findByCategoryid(@PathVariable long id) {


		Category  category=  categoryService.findByCategoryId(id);



		return  new CategoryResponce(

				category.getCategoryId(),
				category.getCategory_name(),
				category.getCategory_description()
		);

	}
	
	@PutMapping("/{id}")
	public CategoryResponce updateCategory(@PathVariable long id, @RequestBody Category c) {

		Category  category=categoryService.updateByCategoryId(id, c);
		return  new CategoryResponce(

				category.getCategoryId(),
				category.getCategory_name(),
				category.getCategory_description()
		);

	}
	
	
	
	
	@DeleteMapping("/{id}")
	public void deleteByCategoryId(@PathVariable long id) {
		
		categoryService.deleteByCategoryId(id);
		
	}
	

}
