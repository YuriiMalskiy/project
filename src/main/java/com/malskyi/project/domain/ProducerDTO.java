package com.malskyi.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProducerDTO {

	@JsonIgnore
	private Long id;

	private String ProducerStringId;
	
	private String name;
	
}
