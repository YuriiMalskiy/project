package com.malskyi.project.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "userOrder")
public class UserOrder extends BaseEntity{
	
	private LocalDate orderDate;
	
	@Column(unique = true)
	private String UserOrderId;
	
	@Column(columnDefinition = "DECIMAL(6,2) DEFAULT '0.00'")
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
}


