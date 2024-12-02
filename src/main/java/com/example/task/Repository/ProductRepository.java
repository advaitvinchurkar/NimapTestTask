package com.example.task.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task.Entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Long> {
	
	
	Product findByProductId(long product_id);
	
	public void deleteByProductId(long product_id); 

}
