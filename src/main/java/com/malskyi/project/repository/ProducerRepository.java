package com.malskyi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malskyi.project.entity.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long>{

	Producer findByProducerId(String producerId);	
}


