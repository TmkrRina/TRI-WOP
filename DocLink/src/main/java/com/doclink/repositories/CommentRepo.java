package com.doclink.repositories;

import org.springframework.data.repository.CrudRepository;

import com.doclink.model.Comment;

public interface CommentRepo extends CrudRepository<Comment, Long> {

}
