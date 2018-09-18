package com.malskyi.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malskyi.project.domain.CommodityDTO;
import com.malskyi.project.service.CommodityService;

@RestController
@RequestMapping("commodities")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	
	@PostMapping
	public ResponseEntity<Void> addCommodity(@RequestBody CommodityDTO commodity){
		commodityService.createCommodity(commodity);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CommodityDTO>> getCommodityByCategory(@PathVariable("categoryId") String categoryId){
		List<CommodityDTO> byCategory = commodityService.getAllByCategoryId(categoryId);
		return new ResponseEntity<List<CommodityDTO>>(byCategory,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<CommodityDTO>> getCommodityByProducer(@PathVariable("producerId") String producerId){
		List<CommodityDTO> byCategory = commodityService.getAllByProducerId(producerId);
		
		return new ResponseEntity<List<CommodityDTO>>(byCategory,HttpStatus.OK);
	}
	
}




