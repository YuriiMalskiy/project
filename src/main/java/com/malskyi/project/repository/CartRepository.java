package com.malskyi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malskyi.project.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

	boolean existsByCartNumber(String cartNumber);
	
	Cart findByCartNumber(String cartNumber);
	
	void deleteByCartNumber(String cartNumber);
}
