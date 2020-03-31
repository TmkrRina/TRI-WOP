package com.doclink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.model.UserModel;
import com.doclink.repo.UserRepo;

import dto.UserDTO;

@Service
public class UserService {
	@Autowired
	UserRepo ur;
	public UserDTO add(UserModel userModel) {
		
		UserModel uModel = ur.save(userModel);
		
		UserDTO userDTO = new UserDTO();
	
		return userDTO;
	}
	
	
}
