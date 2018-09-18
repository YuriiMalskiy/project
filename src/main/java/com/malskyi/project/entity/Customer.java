package com.malskyi.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(indexes = @Index(columnList = "customerStringId"))
public class Customer extends BaseEntity{

	@Column(nullable = false, unique = true)
	private String customerStringId;
	
	@Column(length = 120, nullable = false)
	private String firstName;
	
	@Column(length = 120, nullable = false)
	private String lastName;
	
	@Column(length = 13, nullable = false)
	private String phoneNumber;

	private String adress;
	
}
