package com.example.task.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	private String product_name;
	
	private double product_price;
	
	
	@ManyToOne
	@JoinColumn(name = "categoryId",nullable = false)
	 @JsonBackReference
	
	private Category category;

	

	
	public long getProduct_id() {
		return productId;
	}


	public void setProduct_id(long product_id) {
		this.productId = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public double getProduct_price() {
		return product_price;
	}


	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}


	

	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	


	public Product(long product_id, String product_name, double product_price, 
			Category category) {
		super();
		this.productId = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		
		this.category = category;
	}
	
	


	public Product() {
		super();
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", product_name=" + product_name + ", product_price=" + product_price
				+ ",  category=" + category + "]";
	}

	
}
