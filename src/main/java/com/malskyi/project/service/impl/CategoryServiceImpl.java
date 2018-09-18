package com.malskyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malskyi.project.domain.CategoryDTO;
import com.malskyi.project.entity.Category;
import com.malskyi.project.repository.CategoryRepository;
import com.malskyi.project.service.CategoryService;
import com.malskyi.project.service.utils.ObjectMapperUtils;
import com.malskyi.project.service.utils.StringUtils;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void createCategory(CategoryDTO category) {
		category.setCategoryId(stringUtils.generate());
		categoryRepository.save(objectMapperUtils.map(category, Category.class));
	}

	@Override
	public List<CategoryDTO> getAll() {
		return objectMapperUtils.mapAll(categoryRepository.findAll(), CategoryDTO.class);
	}

	@Override
	public void updateCategory(CategoryDTO categoryDTO) {
		 categoryRepository.save(objectMapperUtils.map(categoryDTO, Category.class));
	}

}
