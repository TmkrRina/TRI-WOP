package com.doclink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.model.CommentModel;
import com.doclink.repo.CommentRepo;

import dto.CommentDTO;

@Service
public class CommentService {
@Autowired
CommentRepo cr;

public CommentDTO comment(CommentModel comment) {
	
	CommentModel cms = cr.save(comment);
	
	CommentDTO csto = new CommentDTO(cms);
	
	return csto;
	
}
	
}
