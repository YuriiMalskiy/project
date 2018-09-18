package com.malskyi.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO {

	@JsonIgnore
	private Long id;
	
	private String customerStringId;
	
	private String firstName;
	
	private String lastName;

	private String phoneNumber;
	
	private String adress;
	
}
