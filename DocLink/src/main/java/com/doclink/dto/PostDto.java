package com.doclink.dto;

import java.util.List;

import com.doclink.model.Comment;
import com.doclink.model.Post;

import lombok.Data;

@Data
public class PostDto {



	private UserDto user;
	private String title;
	private String description;
	private String date;
	private List<Comment> comments;
	
	
	
	public PostDto(Post post) {
		this.title = post.getTitle();
		this.user = new UserDto(post.getUser());
		this.description = post.getDescription();
		this.date=post.getDate();
		this.comments = post.getComments();
	}
}
