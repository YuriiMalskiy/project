package com.malskyi.project.service;

import java.util.List;

import com.malskyi.project.domain.ProducerDTO;

public interface ProducerService {

	void createProducer(ProducerDTO producerDTO);
	
	void updateProducer(ProducerDTO producerDTO);
	
	List<ProducerDTO> getAll();
	
}
