package com.doclink.repo;

import org.springframework.data.repository.CrudRepository;

import com.doclink.model.PostModel;

public interface PostRepo extends CrudRepository<PostModel, Long>{

}
