package com.doclink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.model.Comment;
import com.doclink.repo.CommentRepo;

import dto.CommentDTO;

@Service
public class CommentService {
@Autowired
CommentRepo cr;

public CommentDTO comment(Comment comment) {
	
	Comment cms = cr.save(comment);
	
	CommentDTO csto = new CommentDTO(cms);
	
	return csto;
	
}
	
}
