package com.malskyi.project.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "commodity")
public class Commodity extends BaseEntity{

	@Column(unique = true)
	private String commodityStringId;
	
	@Column(nullable = false)
	private String name;
	private String description;
	private String imageURL;
	private int count;
	
	@Column(columnDefinition = "DECIMAL(10,2) DEFAULT '0.00'")
	private BigDecimal price;
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToOne
	@JoinColumn(name = "producer_id")
	private Producer producer;
}
