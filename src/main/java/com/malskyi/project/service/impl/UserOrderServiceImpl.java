package com.malskyi.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malskyi.project.domain.UserOrderDTO;
import com.malskyi.project.entity.UserOrder;
import com.malskyi.project.repository.UserOrderRepository;
import com.malskyi.project.service.UserOrderService;
import com.malskyi.project.service.utils.ObjectMapperUtils;
import com.malskyi.project.service.utils.StringUtils;

@Service
public class UserOrderServiceImpl implements UserOrderService {

	@Autowired
	private UserOrderRepository orderRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void createOrder(UserOrderDTO userOrderDTO) {
		userOrderDTO.setUserOrderStringId(stringUtils.generate(30));
		orderRepository.save(objectMapperUtils.map(userOrderDTO, UserOrder.class));
		
	}

	@Override
	public List<UserOrderDTO> getOrdersByDate(UserOrderDTO userOrderDTO) {
		//?
		//?
		//?
		//?
		//?
		//?
		
		return null;
	}

}