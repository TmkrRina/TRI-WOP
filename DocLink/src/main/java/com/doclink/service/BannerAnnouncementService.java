package com.doclink.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.doclink.exception.ResourceNotFoundException;
import com.doclink.model.Post;
import com.doclink.model.User;
import com.doclink.repositories.PostRepo;
import com.doclink.repositories.UserRepo;

@Service
public class BannerAnnouncementService implements IBannerAnnouncement {
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private UserRepo userRepo;

	public Post creatPost(Post post, long id) {
		post.setDescription(post.getDescription());
		post.setDate(post.getDate());
		Optional<User> user = userRepo.findById(id);
		user.orElseThrow(() -> new ResourceNotFoundException("User not found", "id", Long.valueOf(id)));
		post.setUser(user.get());
		postRepo.save(post);
		return post;
	}

}
