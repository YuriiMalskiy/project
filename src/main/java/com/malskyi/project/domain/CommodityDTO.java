package com.malskyi.project.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.malskyi.project.entity.Category;
import com.malskyi.project.entity.Producer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommodityDTO {

	@JsonIgnore
	private Long id;
	
	private String commodityStringId;
	
	private String name;
	private String description;
	private String imageURL;
	private int count;

	private BigDecimal price;
	private Category category;
	private Producer producer;
	
}
