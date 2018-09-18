package com.malskyi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malskyi.project.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	
	
}
