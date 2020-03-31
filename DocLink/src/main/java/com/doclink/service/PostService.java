package com.doclink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.model.PostModel;
import com.doclink.repo.PostRepo;

import dto.PostDTO;

@Service
public class PostService {
	
@Autowired
PostRepo pr;

public PostDTO post(PostModel posts) {
	
	PostModel pms = pr.save(posts);
	
	PostDTO pst = new PostDTO(pms);
	
	return pst;
	
}
}
