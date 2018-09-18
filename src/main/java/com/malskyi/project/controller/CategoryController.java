package com.malskyi.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malskyi.project.domain.CategoryDTO;
import com.malskyi.project.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	public CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<Void> addCategory(@RequestBody CategoryDTO dto){
		categoryService.createCategory(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> getCategories(){
		return new ResponseEntity<List<CategoryDTO>>(categoryService.getAll(), HttpStatus.OK);
	}
}
