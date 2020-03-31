package com.doclink.repo;

import org.springframework.data.repository.CrudRepository;

import com.doclink.model.UserModel;

public interface UserRepo extends CrudRepository<UserModel,Long> {
	
}