package com.malskyi.project.service;

import com.malskyi.project.domain.CartDTO;

public interface CartService {

	void create(CartDTO cart);
	
	CartDTO get(String cartNumber);
	
	void delete(String cartNumber);
	
	void update(CartDTO cart);
}
