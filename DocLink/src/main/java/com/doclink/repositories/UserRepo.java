package com.doclink.repositories;

import org.springframework.data.repository.CrudRepository;

import com.doclink.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByIdIn(List<Long> userIds);
}