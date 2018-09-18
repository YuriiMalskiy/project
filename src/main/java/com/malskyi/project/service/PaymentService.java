package com.malskyi.project.service;

import com.malskyi.project.domain.PaymentDTO;

public interface PaymentService {

	void addPayment(PaymentDTO paymentDTO);
	
	void updatePayment(PaymentDTO paymentDTO);
	
}
