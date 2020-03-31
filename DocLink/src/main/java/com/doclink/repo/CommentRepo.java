package com.doclink.repo;

import org.springframework.data.repository.CrudRepository;

import com.doclink.model.Comment;

public interface CommentRepo extends CrudRepository<Comment, Long> {

}
