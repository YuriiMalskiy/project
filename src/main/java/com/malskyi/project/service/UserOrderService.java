package com.malskyi.project.service;

import java.time.LocalDate;
import java.util.List;

import com.malskyi.project.domain.UserOrderDTO;

public interface UserOrderService {

	void createOrder(UserOrderDTO userOrderDTO);
	
	List<UserOrderDTO> getOrdersByDate(LocalDate date);
	
	List<UserOrderDTO> getAll();
}
