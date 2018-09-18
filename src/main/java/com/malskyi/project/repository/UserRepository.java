package com.malskyi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malskyi.project.entity.UserEntity;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long>{

	UserEntity findByUsername(String username);
	
	boolean existsByUsername(String username);
}
