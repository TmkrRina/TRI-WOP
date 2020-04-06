package com.doclink.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.doclink.exception.FormErrorsException;
import com.doclink.exception.ResourceNotFoundException;
import com.doclink.model.Announcement;
import com.doclink.model.Comment;
import com.doclink.repositories.PostRepo;
import com.doclink.service.CommentService;

@RestController
@CrossOrigin
public class CommentController {

@Autowired
PostRepo postrepo;

@Autowired
CommentService commentService;

	 @PostMapping("/api/users/{user_id}/announcement/{post_id}/comment")
	    public @ResponseBody Comment create(@Valid @RequestBody Comment comment, BindingResult result, Errors errors, @PathVariable("user_id") Long user_id,@PathVariable("post_id") Long post_id) throws Exception, FormErrorsException {
	     if (result.hasErrors()) {
	            throw new FormErrorsException(errors);
	        } else {

	            comment = commentService.create(comment, user_id,post_id);
	            // eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user,
	            // request.getLocale(), request.getContextPath()));
	        }
	        return comment;
		// return null;
	    }

	



}
