package com.doclink.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doclink.model.Comment;
import com.doclink.model.Doctor;
import com.doclink.model.Post;
import com.doclink.model.PostType;
import com.doclink.model.User;
import com.doclink.model.UserRole;
import com.doclink.service.CommentService;
import com.doclink.service.DoctorService;
import com.doclink.service.PostService;

import com.doclink.dto.CommentDto;
import com.doclink.dto.DoctorDto;
import com.doclink.dto.PostDto;
import com.doclink.dto.UserDto;

@RestController
public class Controller {
	@Autowired
	UserService us;
	@Autowired
	PostService ps;
	@Autowired
	CommentService cs;
	@Autowired
	DoctorService doctor_service;
	

	List<User> users = new ArrayList<User>();
	List<Post> posts = new ArrayList<Post>();

	@GetMapping("/user")
	public UserDto add() {
		User nm2 = new User((long) 4, "perry", "luigi", "asdsfghjklkfds", "123ed", "male", "iowa", "usa",
				"adsdasd", true, UserRole.Role_Admin);
		
		return us.add(nm2);
	}

	@GetMapping("/post")
	private PostDto post() {
		User nm2 = new User((long) 1, "perry", "luigi", "asdsfghjklkfds", "123ed", "male", "iowa", "usa",
				"adsdasd", true, UserRole.Role_Admin);

//		us.add(nm2);
		Post pm = new Post((long) 1, "hi", "jhadsjfalk", "12/34/67", PostType.Annoucement, nm2);

		return ps.post(pm);

	}

	@GetMapping("/comment")
	private CommentDto comment() {
		User nm2 = new User((long) 1, "perry", "luigi", "asdsfghjklkfds", "123ed", "male", "iowa", "usa",
				"adsdasd", true, UserRole.Role_Admin);
		Post pm = new Post((long) 7, "hi", "jhadsjfalk", "12/34/67", PostType.Annoucement, nm2);
		Comment cm = new Comment((long) 1, nm2, "12/21/21", "sjdajnads", pm);
		return cs.comment(cm);
	}

	@GetMapping("/doctor")
	private DoctorDto doctor() {
		User nm2 = new User((long) 1, "perry", "luigi", "asdsfghjklkfds", "123ed", "male", "iowa", "usa",
				"adsdasd", true, UserRole.Role_Admin);
		Doctor dc = new Doctor((long) 1, "sdgfbdsjkhfgdsuyifhdsbuyf", "fjhsdfgdsvfsdf", nm2);
		return doctor_service.doctor(dc);
	}

}
