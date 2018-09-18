package com.malskyi.project.service;

import java.util.List;

import com.malskyi.project.domain.PaymentDTO;

public interface PaymentService {

	void addPayment(PaymentDTO paymentDTO);
	
	void updatePayment(PaymentDTO paymentDTO);
	
	List<PaymentDTO> getAll();
}
