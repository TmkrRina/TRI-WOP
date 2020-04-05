package com.doclink.dto;

import com.doclink.model.Comment;
import com.doclink.model.Post;

import lombok.Data;

@Data
public class CommentDto {
	
	public CommentDto(Comment comment) {
		
		this.date = comment.getDate();
		this.description = comment.getDescription();
		this.posts = comment.getPosts();
	}
	
	private String date;
	private String description;
	private Post posts;
	
	
}
