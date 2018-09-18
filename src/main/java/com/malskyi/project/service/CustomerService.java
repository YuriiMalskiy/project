package com.malskyi.project.service;

import com.malskyi.project.domain.CustomerDTO;

public interface CustomerService {

	void createCustomer(CustomerDTO customerDTO);
	
	void updateCustomer(CustomerDTO customerDTO);
	
}
