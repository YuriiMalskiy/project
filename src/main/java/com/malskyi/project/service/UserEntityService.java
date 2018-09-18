package com.malskyi.project.service;

import java.util.List;

import com.malskyi.project.domain.UserEntityDTO;


public interface UserEntityService {
	
	void save(UserEntityDTO dto);
	
	UserEntityDTO findById(Long id);
	
	List<UserEntityDTO> findAll();
	
	boolean existsByLogin(String login);
	
	UserEntityDTO findByUsername(String username);
	
	String signin(String username, String password);
}
