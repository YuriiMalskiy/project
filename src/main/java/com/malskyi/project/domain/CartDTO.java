package com.malskyi.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.malskyi.project.entity.Commodity;
import com.malskyi.project.entity.UserOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDTO {

	@JsonIgnore
	private Long id;
	
	private Commodity commodity;
	
	private UserOrder order;
	
	private String cartNumber;
	
	private int count;

}
