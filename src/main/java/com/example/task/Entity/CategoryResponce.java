package com.example.task.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class CategoryResponce {
	

	private long categoryId;
	
	private String category_name;
	
	private String category_description;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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

	public CategoryResponce(long categoryId, String category_name, String category_description) {
		super();
		this.categoryId = categoryId;
		this.category_name = category_name;
		this.category_description = category_description;
	}

	@Override
	public String toString() {
		return "CategoryResponce [categoryId=" + categoryId + ", category_name=" + category_name
				+ ", category_description=" + category_description + "]";
	}

	
}
