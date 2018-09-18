package com.malskyi.project.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.malskyi.project.entity.Customer;
import com.malskyi.project.entity.Payment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserOrderDTO {

	@JsonIgnore
	private Long id;
	
	private String UserOrderId;
	private LocalDate orderDate;	
	private BigDecimal price;
	private Customer customer;
	private Payment payment;
}
