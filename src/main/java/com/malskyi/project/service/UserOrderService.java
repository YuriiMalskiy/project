package com.malskyi.project.service;

import java.util.List;

import com.malskyi.project.domain.UserOrderDTO;

public interface UserOrderService {

	void createOrder(UserOrderDTO userOrderDTO);
	
	List<UserOrderDTO> getOrdersByDate(UserOrderDTO userOrderDTO);
	
}
