package com.example.task.Services;

import java.util.List;

import com.example.task.Entity.Category;
import com.example.task.Entity.CategoryResponce;
import com.example.task.Entity.PaginatedResponse;
import com.example.task.Entity.Product;
import com.example.task.Entity.ProductResponse;

public interface ProductServices {
	
	public Product insertProduct(Product p);
		
	List<Product> getAllProduct();
	
	Product  findByProductId(long product_id);
	
	public void deleteByProductId(long product_id); 
	
	Product updateByProductId(long product_id, Product productinfo);
	
	 PaginatedResponse<ProductResponse> getPaginatedProducts(int page, int size,List<ProductResponse> categories) ;


}
