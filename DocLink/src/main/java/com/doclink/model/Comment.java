package com.doclink.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Comment {
	
private  Comment() {
	// TODO Auto-generated method stub

}
	
	
	public Comment(Long id, User user, String date, String description, Post posts) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
		this.description = description;
		this.posts = posts;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
//	@OneToMany
//	private List<PostModel> post;
	private String date;
	private String description;
	@ManyToOne
	private Post posts;

}
