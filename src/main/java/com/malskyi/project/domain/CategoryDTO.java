package com.malskyi.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {
	
	@JsonIgnore
	private Long id;
	
	private String categoryId;
	
	private String name;

}
