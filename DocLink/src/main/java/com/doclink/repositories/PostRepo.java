package com.doclink.repositories;

import com.doclink.model.PostType;
import org.springframework.data.repository.CrudRepository;

import com.doclink.model.Post;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long>{
//    List<Post> findAllByType(PostType banner_announcement);
}
