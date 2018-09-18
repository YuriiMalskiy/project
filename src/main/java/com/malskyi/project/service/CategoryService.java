package com.malskyi.project.service;

import java.util.List;

import com.malskyi.project.domain.CategoryDTO;

public interface CategoryService {

	void createCategory(CategoryDTO category);
	
	List<CategoryDTO> getAll();
	
	void updateCategory(CategoryDTO categoryDTO);
}
