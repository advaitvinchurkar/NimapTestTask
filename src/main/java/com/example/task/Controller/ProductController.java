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

import com.example.task.Entity.PaginatedResponse;
import com.example.task.Entity.Product;
import com.example.task.Entity.ProductResponse;
import com.example.task.Services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductServices productServices;
	
	
	@PostMapping("/creareproduct")
	public ProductResponse createProduct(@RequestBody Product p) {
		Product product =productServices.insertProduct(p);
		
		return  new ProductResponse(
                product.getProduct_id(),
                product.getProduct_name(),
                product.getProduct_price(),
                product.getCategory().getCategoryId(),
                product.getCategory().getCategory_name(),
                product.getCategory().getCategory_description()
        );
		 
		
	}
	
	@GetMapping("/getallproduct")
	public PaginatedResponse<ProductResponse> getAllProduct(@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size ) {
		
		
		
		return productServices.getPaginatedProducts(page, size, productServices.getAllProduct().stream()
	            .map(product -> new ProductResponse(
	                product.getProduct_id(),
	                product.getProduct_name(),
	                product.getProduct_price(),
	                product.getCategory().getCategoryId(),
	                product.getCategory().getCategory_name(),
	                product.getCategory().getCategory_description()
	            ))
	            .collect(Collectors.toList()));
	    }
		
	
	
	@GetMapping("/findbyid/{id}")
	public ProductResponse getProductByID(@PathVariable long id) {
		Product  product=  productServices.findByProductId(id);
		
		
		
		return  new ProductResponse(
                product.getProduct_id(),
                product.getProduct_name(),
                product.getProduct_price(),
                product.getCategory().getCategoryId(),
                product.getCategory().getCategory_name(),
                product.getCategory().getCategory_description()
        );
		
	}
	
	@PutMapping("/updateproduct/{id}")
	public Product updateProduct(@PathVariable long id, @RequestBody Product p) {
		
		return productServices.updateByProductId(id, p);
		
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public void deleteByProductId(@PathVariable long id) {
		
		productServices.deleteByProductId(id);
	}
	
	
	
	
	
	
	
	
}