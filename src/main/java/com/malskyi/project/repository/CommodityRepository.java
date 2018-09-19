package com.malskyi.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malskyi.project.entity.Commodity;

@Repository
public interface CommodityRepository  extends JpaRepository<Commodity, Long>{

	Commodity findByCommodityStringId(String commodityStringId);
	
	List<Commodity> findByCategoryId(String categoryId);

	List<Commodity> findByProducerId(String producerId);

}
