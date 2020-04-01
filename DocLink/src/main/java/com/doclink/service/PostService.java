package com.doclink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.model.Post;
import com.doclink.repo.PostRepo;

import com.doclink.dto.PostDto;

@Service
public class PostService {
	
@Autowired
PostRepo pr;

public PostDto post(Post posts) {
	
	Post pms = pr.save(posts);
	
	PostDto pst = new PostDto(pms);
	
	return pst;
	
}
}
