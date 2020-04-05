package com.doclink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.doclink.exception.ResourceNotFoundException;
import com.doclink.model.Post;
import com.doclink.model.User;
import com.doclink.repositories.AnnouncementRepo;
import com.doclink.repositories.PostRepo;
import com.doclink.repositories.UserRepo;

public abstract class PostService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AnnouncementRepo announcementRepo;
@Autowired
private PostRepo postRepo;

    protected User getUser(long id) {
        Optional<User> user = userRepo.findById(id);
        user.orElseThrow(() -> new ResourceNotFoundException("User not found", "id", Long.valueOf(id)));
        return user.get();
    }
    protected Post getAnnouncement(long id) {
        Post postAnnouncement = postRepo.findById(id).get();
        
        return postAnnouncement;
    }
    
}
