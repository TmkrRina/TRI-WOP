package com.doclink.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doclink.model.CommentModel;
import com.doclink.model.PostModel;
import com.doclink.model.PostType;
import com.doclink.model.UserModel;
import com.doclink.model.UserRole;
import com.doclink.service.CommentService;
import com.doclink.service.PostService;
import com.doclink.service.UserService;

import dto.CommentDTO;
import dto.PostDTO;
import dto.UserDTO;

@RestController
public class Controller {
	@Autowired
	UserService us;
	@Autowired
	PostService ps;
	@Autowired
	CommentService cs;

	List<UserModel> users = new ArrayList<UserModel>();
    List<PostModel>posts =new ArrayList<PostModel>();
	@GetMapping("/user")
	public UserDTO add() {
		UserModel nm = new UserModel((long) 1, "perry", "luigi", "sdfsdf", "123ed", "male", "iowa", "usa", "adsdasd",
				true, UserRole.Role_Admin);
		
		return us.add(nm);
	}

	@GetMapping("/post")
	private PostDTO post() {
		UserModel nm = new UserModel((long) 1, "perry", "luigi", "sdfsdf", "123ed", "male", "iowa", "usa", "adsdasd",
				true, UserRole.Role_Admin);
		us.add(nm);
		users.add(nm);
		
		PostModel pm = new PostModel((long) 1, "hi", "jhadsjfalk", "12/34/67", PostType.Annoucement, users.get(0));

		return ps.post(pm);

	}
	@GetMapping("/comment")
	private CommentDTO comment() {
		UserModel nm = new UserModel((long) 1, "perry", "luigi", "sdfsdf", "123ed", "male", "iowa", "usa", "adsdasd",
				true, UserRole.Role_Admin);
		PostModel pm = new PostModel((long) 1, "hi", "jhadsjfalk", "12/34/67", PostType.Annoucement, users.get(0));
		us.add(nm);
		ps.post(pm);
		
		users.add(nm);
		posts.add(pm);
		CommentModel cm = new CommentModel((long) 1, users.get(0), "12/34/6567", "its working");
		return cs.comment(cm);
		}
	
}
