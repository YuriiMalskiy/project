package com.malskyi.project.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.malskyi.project.domain.CommodityDTO;

public interface CommodityService {

	void createCommodity(CommodityDTO commodityDTO);
	
	void updateCommodity(CommodityDTO commodityDTO);
	
	CommodityDTO findByStringId(String commodityStringId);
	
	List<CommodityDTO> getAllByCategoryId(String categoryId);

	List<CommodityDTO> getAllByProducerId(String producerId);
	
	void uploadImage(MultipartFile file, String commodityId);
	
	List<CommodityDTO> getAll();
	
	List<CommodityDTO> getAll(Pageable pageable);
}
