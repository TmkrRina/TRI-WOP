package com.doclink.repo;

import org.springframework.data.repository.CrudRepository;

import com.doclink.model.User;

public interface UserRepo extends CrudRepository<User,Long> {

    User findByEmail(String email);
}