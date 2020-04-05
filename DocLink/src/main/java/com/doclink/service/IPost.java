package com.doclink.service;

import com.doclink.model.User;
import org.springframework.web.bind.annotation.RequestParam;

import com.doclink.model.Post;


public interface IPost {
	Post create(Post post, Long userId);

	Post update(Post post);
}

