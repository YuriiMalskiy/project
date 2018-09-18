package com.malskyi.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malskyi.project.domain.PaymentDTO;
import com.malskyi.project.service.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<Void> addPayment(@RequestBody PaymentDTO dto){
		paymentService.addPayment(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PaymentDTO>> getPayments(){
		return new ResponseEntity<List<PaymentDTO>>(paymentService.getAll(), HttpStatus.OK);
	}
	
}
