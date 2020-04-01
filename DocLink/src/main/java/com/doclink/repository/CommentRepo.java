package com.doclink.repository;

import org.springframework.data.repository.CrudRepository;

import com.doclink.model.CommentModel;

public interface CommentRepo extends CrudRepository<CommentModel, Long> {

}
