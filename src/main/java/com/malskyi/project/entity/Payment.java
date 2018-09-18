package com.malskyi.project.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(indexes = @Index(columnList = "paymentId"))
public class Payment extends BaseEntity{

	@Column(nullable = false, unique = true)
	private String paymentId;
	
	private LocalDate date;
	
	private String status;
	
	
}
