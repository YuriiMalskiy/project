package com.malskyi.project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.malskyi.project.domain.UserOrderDTO;
import com.malskyi.project.service.UserOrderService;

@RestController
@RequestMapping("orders")
public class OrderController {

	@Autowired
	UserOrderService orderService;
	
	@PostMapping
	public ResponseEntity<Void> addOrder(@RequestBody UserOrderDTO dto){
		orderService.createOrder(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserOrderDTO>> getOrders(){
		return new ResponseEntity<List<UserOrderDTO>>(orderService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("date")
	public ResponseEntity<List<UserOrderDTO>> getOrdersByDate(@PathVariable("orderDate") LocalDate date){
		return new ResponseEntity<List<UserOrderDTO>>(orderService.getOrdersByDate(date), HttpStatus.OK);
	}
}
