package com.doclink.repositories;

import org.springframework.data.repository.CrudRepository;

import com.doclink.model.Post;

public interface PostRepo extends CrudRepository<Post, Long>{
	
}
