package com.malskyi.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malskyi.project.domain.ProducerDTO;
import com.malskyi.project.entity.Producer;
import com.malskyi.project.repository.ProducerRepository;
import com.malskyi.project.service.ProducerService;
import com.malskyi.project.service.utils.ObjectMapperUtils;
import com.malskyi.project.service.utils.StringUtils;

@Service
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	private ProducerRepository producerRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void createProducer(ProducerDTO producerDTO) {
		producerDTO.setProducerStringId(stringUtils.generate());
		producerRepository.save(objectMapperUtils.map(producerDTO, Producer.class));
	}

	@Override
	public void updateProducer(ProducerDTO producerDTO) {
		producerRepository.save(objectMapperUtils.map(producerDTO, Producer.class));
	}

}
