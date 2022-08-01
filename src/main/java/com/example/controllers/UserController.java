package com.example.controllers;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.example.entity.UserEntity;
import com.example.repository.UserRepository;


@RestController
public class UserController {
	
	private static final String Dsc = null;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/save")
	public ResponseEntity<UserEntity> saveUserDetail(@RequestBody UserEntity userEntity){
		UserEntity save = (UserEntity) this.userRepository.save(userEntity);
		return ResponseEntity.ok(save);
	}
	
	
	
	@GetMapping("/list")
	public List<UserEntity> getAllUser(){
		Sort sort = Sort.by("userName").ascending();
		List<UserEntity> findAll = this.userRepository.findAll(sort);
		return findAll;
	}

	

	
	//delete single user using user id
	@DeleteMapping("/delete")
	public void deleteUserById(@RequestParam("id") int Id) {
		Optional<UserEntity> entity=userRepository.findById(Id);
		this.userRepository.delete(entity.get());
	}
	//update single user using user id
	  @PostMapping("/update")
	  public void update( @PathVariable("id") Integer id, @RequestBody UserEntity userEntity) { 
		  
			UserEntity save = (UserEntity) this.userRepository.save(userEntity);

		
		  
	  }
	 
	  
		
	
	}

