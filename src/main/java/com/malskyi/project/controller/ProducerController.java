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

import com.malskyi.project.domain.ProducerDTO;
import com.malskyi.project.service.ProducerService;

@RestController
@RequestMapping("producers")
public class ProducerController {

	@Autowired
	ProducerService producerService;
	
	@PostMapping
	public ResponseEntity<Void> addProducer(@RequestBody ProducerDTO dto){
		producerService.createProducer(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProducerDTO>> getProducers(){
		return new ResponseEntity<List<ProducerDTO>>(producerService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("update")
	public ResponseEntity<Void> updateProducer(@RequestBody ProducerDTO dto){
		producerService.updateProducer(dto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("delete")
	public ResponseEntity<Void> deleteProducer(@RequestBody ProducerDTO dto){
		producerService.deleteProducer(dto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
