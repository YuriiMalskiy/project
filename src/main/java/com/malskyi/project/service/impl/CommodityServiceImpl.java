package com.malskyi.project.service.impl;

import static com.malskyi.project.constants.ErrorMessages.NO_RECORD_FOUND;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.malskyi.project.domain.CommodityDTO;
import com.malskyi.project.entity.Commodity;
import com.malskyi.project.exceptions.CommodityNotFoundException;
import com.malskyi.project.repository.CategoryRepository;
import com.malskyi.project.repository.CommodityRepository;
import com.malskyi.project.service.CommodityService;
import com.malskyi.project.service.cloudinary.CloudinaryService;
import com.malskyi.project.service.utils.ObjectMapperUtils;
import com.malskyi.project.service.utils.StringUtils;

@Service
public class CommodityServiceImpl implements CommodityService{

	@Autowired
	private CommodityRepository commodityRepository;
	
//	@Autowired
//	private CategoryRepository categoryRepository;
//	
//	@Autowired
//	private ProducerRepository producerRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Autowired
	private CloudinaryService cloudinaryService;
	
	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void createCommodity(CommodityDTO commodityDTO) {
		commodityDTO.setCommodityStringId(stringUtils.generate(20));
		commodityRepository.save(objectMapperUtils.map(commodityDTO, Commodity.class));
	}

	@Override
	public void updateCommodity(CommodityDTO commodityDTO) {
		commodityRepository.save(objectMapperUtils.map(commodityDTO, Commodity.class));
	}

	@Override
	public CommodityDTO findByStringId(String commodityStringId) {
		return objectMapperUtils.map(commodityRepository.findByCommodityStringId(commodityStringId), CommodityDTO.class);
	}

	@Override
	public List<CommodityDTO> getAllByCategoryId(String categoryId) {
		return objectMapperUtils.mapAll(commodityRepository.findByCategoryId(categoryId), CommodityDTO.class);
	}

	@Override
	public List<CommodityDTO> getAllByProducerId(String producerId) {
		return objectMapperUtils.mapAll(commodityRepository.findByProducerId(producerId), CommodityDTO.class);
	}
	
	@Override
	public void uploadImage(MultipartFile file, String commodityStringId) {
		String imageURL = cloudinaryService.uploadFile(file, "commodity_name: " + commodityRepository.findByCommodityStringId(commodityStringId).getName());
		
		Commodity commodity = commodityRepository.findByCommodityStringId(commodityStringId);
		if(commodity == null) {
			throw new CommodityNotFoundException(NO_RECORD_FOUND);
		}
		
		commodity.setImageURL(imageURL);
		commodityRepository.save(commodity);		
	}

	@Override
	public List<CommodityDTO> getAll() {
		return objectMapperUtils.mapAll(commodityRepository.findAll(), CommodityDTO.class);
	}

	@Override
	public List<CommodityDTO> getAll(Pageable pageable) {
		
		Page<Commodity> page = commodityRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
		List<Commodity> commodities = page.getContent();
		
		return objectMapperUtils.mapAll(commodities, CommodityDTO.class);
	}

	

}
