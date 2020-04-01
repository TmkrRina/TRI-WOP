package com.doclink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.model.Comment;
import com.doclink.repo.CommentRepo;

import com.doclink.dto.CommentDto;

@Service
public class CommentService {
    @Autowired
    CommentRepo cr;

    public CommentDto comment(Comment comment) {

        Comment cms = cr.save(comment);

        CommentDto csto = new CommentDto(cms);

        return csto;

    }

}
