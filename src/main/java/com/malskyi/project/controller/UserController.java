package com.malskyi.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.malskyi.project.domain.UserEntityDTO;
import com.malskyi.project.domain.request.SigninRequest;
import com.malskyi.project.domain.response.SigninResponse;
import com.malskyi.project.service.UserEntityService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserEntityService userEntityService;
	
	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody UserEntityDTO dto){
		userEntityService.save(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<UserEntityDTO>> getUsers(){
		return new ResponseEntity<List<UserEntityDTO>>(userEntityService.findAll(), HttpStatus.OK);		
	}
	
	@PostMapping("signin")
	public ResponseEntity<SigninResponse> signin(@RequestBody SigninRequest request){
		String token = userEntityService.signin(request.getUsername(), request.getPassword());
		String role = "";
		System.out.println(token + "/n" + request.getUsername() + "\n" + request.getPassword());
		
		if(token != null) {
			role = userEntityService.findByUsername(request.getUsername()).getRole().toString();
			System.out.println("Role:" + role);
		}
		
		return new ResponseEntity<SigninResponse>(new SigninResponse(token, role), HttpStatus.OK);
		
	}
	
	@GetMapping("check-login")
	public ResponseEntity<Boolean> checkUserLogin(@RequestParam("login") String login){
		return new ResponseEntity<Boolean>(userEntityService.existsByLogin(login), HttpStatus.OK);
	}
	
	@PostMapping("deleteUser")
	public ResponseEntity<Void> deleteUser(@RequestBody UserEntityDTO dto){
		userEntityService.deleteUser(dto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("updateUser")
	public ResponseEntity<Void> updateUser(@RequestBody UserEntityDTO dto){
		userEntityService.updateUser(dto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
