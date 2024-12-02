package com.example.task.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.Entity.CategoryResponce;
import com.example.task.Entity.PaginatedResponse;
import com.example.task.Entity.Product;
import com.example.task.Entity.ProductResponse;
import com.example.task.Exception.InvalidRequestException;
import com.example.task.Exception.ResourceNotFoundException;
import com.example.task.Repository.ProductRepository;

@Service
public class productServiceimpl implements ProductServices {

	@Autowired
	private ProductRepository  productRepository;

	@Override
	public Product insertProduct(Product p) {
		
		if (p.getProduct_name() == null || p.getProduct_name().isEmpty()) {
            throw new InvalidRequestException("Product name cannot be empty.");
        }
        return productRepository.save(p);
		
		//return pr.save(p);
	}

	@Override
	public List<Product> getAllProduct() {
		
		 List<Product> products = productRepository.findAll();
	        if (products.isEmpty()) {
	            throw new ResourceNotFoundException("No products found.");
	        }
	        return products;
		
		
	}

	@Override
	public Product findByProductId(long product_id) {
		
		 return productRepository.findById(product_id)
	                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + product_id));
		//return pr.findByProductId(product_id);
	}

	@Override
	public void deleteByProductId(long product_id) {
		
		 if (!productRepository.existsById(product_id)) {
	            throw new ResourceNotFoundException("Product not found with ID: " + product_id);
	        }
		
		 productRepository.deleteById(product_id);
	}

	@Override
	public Product updateByProductId(long product_id, Product productinfo) {
		 Product product = productRepository.findById(product_id)
	                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + product_id));
		 
		 if (productinfo.getProduct_name() == null || productinfo.getProduct_name().isEmpty()) {
	            throw new InvalidRequestException("Product name cannot be empty.");
	        }
		product.setProduct_name(productinfo.getProduct_name());
		product.setProduct_price(productinfo.getProduct_price());
		product.setCategory(productinfo.getCategory());
		
		return productRepository.save(product);
	}
	
	 public PaginatedResponse<ProductResponse> getPaginatedProducts(int page, int size,List<ProductResponse> productresponse) {
	        int totalItems = productresponse.size();
	        int start = Math.min(page * size, totalItems);
	        int end = Math.min(start + size, totalItems);

	        List<ProductResponse> paginatedProducts = productresponse.subList(start, end);
	        int totalPages = (int) Math.ceil((double) totalItems / size);

	        return new PaginatedResponse<>(paginatedProducts, page, totalPages, totalItems);
	    }

	
}
