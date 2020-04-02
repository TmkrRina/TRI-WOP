package com.doclink.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.doclink.model.Post;


public interface IBannerAnnouncement {
	Post creatPost(Post post, long id);
}
