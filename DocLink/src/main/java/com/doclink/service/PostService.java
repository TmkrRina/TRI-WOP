package com.doclink.service;

import com.doclink.exception.ResourceNotFoundException;
import com.doclink.model.HealthIssue;
import com.doclink.model.User;
import com.doclink.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class PostService {
    @Autowired
    private UserRepo userRepo;

    protected User getUser(long id) {
        Optional<User> user = userRepo.findById(id);
        user.orElseThrow(() -> new ResourceNotFoundException("User not found", "id", Long.valueOf(id)));
        return user.get();
    }
}
