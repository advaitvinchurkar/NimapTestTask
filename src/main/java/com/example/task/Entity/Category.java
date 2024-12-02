package com.example.task.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long categoryId;
	
	private String category_name;
	
	private String category_description;
	
	 @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	  @JsonManagedReference
	private List<Product> product;

	public Category(long categoryId, String category_name, String category_description, List<Product> product) {
		super();
		this.categoryId = categoryId;
		this.category_name = category_name;
		this.category_description = category_description;
		this.product = product;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	public Category(long categoryId, String category_name, String category_description) {
		super();
		this.categoryId = categoryId;
		this.category_name = category_name;
		this.category_description = category_description;
	}

	public Category() {
		super();
		
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", category_name=" + category_name + ", category_description="
				+ category_description + ", product=" + product + "]";
	}
	
}
