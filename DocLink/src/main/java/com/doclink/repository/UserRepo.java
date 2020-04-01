package com.doclink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doclink.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModel,Long> {
	Optional<UserModel> findByUsernameOrEmail(String username, String email);
	List<UserModel> findByIdIn(List<Long> userIds);
}