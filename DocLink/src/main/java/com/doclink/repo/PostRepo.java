package com.doclink.repo;

import org.springframework.data.repository.CrudRepository;

import com.doclink.model.Post;

public interface PostRepo extends CrudRepository<Post, Long>{

}
