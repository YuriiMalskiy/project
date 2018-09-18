package com.malskyi.project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malskyi.project.entity.UserOrder;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

	List<UserOrder> findAllByOrderDate(LocalDate date);
	
}
