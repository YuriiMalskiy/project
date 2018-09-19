package com.malskyi.project.service.impl;

import java.time.LocalDate;
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
		userOrderDTO.setUserOrderId(stringUtils.generate(30));
		orderRepository.save(objectMapperUtils.map(userOrderDTO, UserOrder.class));
		
	}

	@Override
	public List<UserOrderDTO> getOrdersByDate(LocalDate date) {
		return objectMapperUtils.mapAll(orderRepository.findByOrderDate(date), UserOrderDTO.class);
	}

	@Override
	public List<UserOrderDTO> getAll() {
		return objectMapperUtils.mapAll(orderRepository.findAll(), UserOrderDTO.class);
	}

	@Override
	public void updateUserOrder(UserOrderDTO userOrderDTO) {
		UserOrderDTO dto = userOrderDTO;
		orderRepository.delete(objectMapperUtils.map(userOrderDTO, UserOrder.class));
		orderRepository.save(objectMapperUtils.map(dto, UserOrder.class));
	}

	@Override
	public void deleteUserOrder(UserOrderDTO userOrderDTO) {
		orderRepository.delete(objectMapperUtils.map(userOrderDTO, UserOrder.class));
	}

}
