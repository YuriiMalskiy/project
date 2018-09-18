package com.malskyi.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malskyi.project.domain.CustomerDTO;
import com.malskyi.project.entity.Customer;
import com.malskyi.project.repository.CustomerRepository;
import com.malskyi.project.service.CustomerService;
import com.malskyi.project.service.utils.ObjectMapperUtils;
import com.malskyi.project.service.utils.StringUtils;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void createCustomer(CustomerDTO customerDTO) {
		customerDTO.setCustomerStringId(stringUtils.generate());
		customerRepository.save(objectMapperUtils.map(customerDTO, Customer.class));
	}

	@Override
	public void updateCustomer(CustomerDTO customerDTO) {
		customerRepository.save(objectMapperUtils.map(customerDTO, Customer.class));
	}

}
