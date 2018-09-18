package com.malskyi.project.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentDTO {

	@JsonIgnore
	private Long id;

	private String paymentId;
	
	private LocalDate date;
	private String status;
	
}
