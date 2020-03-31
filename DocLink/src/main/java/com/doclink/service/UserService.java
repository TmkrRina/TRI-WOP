package com.doclink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.model.User;
import com.doclink.repo.UserRepo;

import dto.UserDTO;

@Service
public class UserService {
	@Autowired
	UserRepo ur;
	public UserDTO add(User userModel) {
		
		User uModel = ur.save(userModel);
		
		UserDTO userDTO = new UserDTO(uModel);
	
		return userDTO;
	}
	
	
}
