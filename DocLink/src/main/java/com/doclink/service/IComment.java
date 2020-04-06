package com.doclink.service;

import com.doclink.model.Comment;

public interface IComment {
	Comment create(Comment comment, Long postId,Long user_id);

	//Comment update(Comment comment);
}
