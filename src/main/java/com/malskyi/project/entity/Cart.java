package com.malskyi.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(indexes = @Index(columnList = "cartNumber"))
public class Cart extends BaseEntity{
		
	@ManyToOne
	@JoinColumn(name = "commodity_id")
	private Commodity commodity;
	
	@ManyToOne
	@JoinColumn(name = "userOrder_id")
	private UserOrder order;
	
	@Column(nullable = false, unique = true, length = 30)
	private String cartNumber;
	
	@Column(nullable = false)
	private int count;
	
}
