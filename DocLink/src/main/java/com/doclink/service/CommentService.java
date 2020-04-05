package com.doclink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.model.Comment;
import com.doclink.repositories.AnnouncementRepo;
import com.doclink.repositories.CommentRepo;

@Service
public class CommentService extends PostService implements IComment{

    @Autowired
   AnnouncementRepo announcementRepo;
    @Autowired
    CommentRepo commentRepo;
	@Override
	public Comment create(Comment comment, Long user_id,Long post_id ) {
		 Comment oldComment = comment;
		 oldComment.setDescription(comment.getDescription());
		 oldComment.setDate(comment.getDate());
		 oldComment.setUser(getUser(user_id));
		 oldComment.setPost( getAnnouncement(post_id));
	        commentRepo.save(oldComment);
	        return (Comment) oldComment;
		
	}

	/*@Override
	public Comment update(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}*/


}
