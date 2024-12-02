package com.example.task.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category findByCategoryId(long catrgory_id);
	
	void deleteByCategoryId(long category_id);


}
