package com.doclink.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data

public class Post {
	

	


	

	public Post(Long id, String title, String description, String date, PostType type, User user
			) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.type = type;
		this.user = user;
		
	}

	public Post() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	//user id;
	
	private String title;
	private String description;
	private String date;
	

	@Enumerated(EnumType.STRING)
	private PostType type;

	@ManyToOne
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "posts",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Comment> comments;
	
}

