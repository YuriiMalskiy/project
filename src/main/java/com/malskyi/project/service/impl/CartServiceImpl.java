package com.malskyi.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malskyi.project.domain.CartDTO;
import com.malskyi.project.entity.Cart;
import com.malskyi.project.repository.CartRepository;
import com.malskyi.project.service.CartService;
import com.malskyi.project.service.utils.ObjectMapperUtils;
import com.malskyi.project.service.utils.StringUtils;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private ObjectMapperUtils objectMapperUtils;

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void create(CartDTO cart) {
		String cartNumber = stringUtils.generate(30);
		if(!cartRepository.existsByCartNumber(cartNumber)){
			cart.setCartNumber(cartNumber);
			Cart cartEntity = objectMapperUtils.map(cart, Cart.class);
			
			cartRepository.save(cartEntity);
		}else {
			// throw new CartAlreadyExistsException();
		}
		
	}

	@Override
	public CartDTO get(String cartNumber) {
		Cart cart = cartRepository.findByCartNumber(cartNumber);
		
		if(cart == null) {
			//
			//throw new CartNotFoundException();
			//
		}
		
		return objectMapperUtils.map(cart, CartDTO.class);
	}

	@Override
	public void delete(String cartNumber) {
		cartRepository.deleteByCartNumber(cartNumber);
	}

	@Override
	public void update(CartDTO cart) {
		cartRepository.save(objectMapperUtils.map(cart, Cart.class));		
		
	}

}
