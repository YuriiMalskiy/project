package com.malskyi.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malskyi.project.domain.PaymentDTO;
import com.malskyi.project.entity.Payment;
import com.malskyi.project.repository.PaymentRepository;
import com.malskyi.project.service.PaymentService;
import com.malskyi.project.service.utils.ObjectMapperUtils;
import com.malskyi.project.service.utils.StringUtils;

import static com.malskyi.project.constants.PaymentStatus.*;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void addPayment(PaymentDTO paymentDTO) {
		paymentDTO.setPaymentId(stringUtils.generate(50));
		paymentDTO.setStatus(PAYMENT_AWAITING);
		paymentRepository.save(objectMapperUtils.map(paymentDTO, Payment.class));
	}

	@Override
	public void updatePayment(PaymentDTO paymentDTO) {
		paymentDTO.setStatus(PAYMENT_COMPLETED);
		paymentRepository.save(objectMapperUtils.map(paymentDTO, Payment.class));
		
	}

}
