package com.malskyi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malskyi.project.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String name);
	
	Category findByCategoryId(String categoryId);
}
