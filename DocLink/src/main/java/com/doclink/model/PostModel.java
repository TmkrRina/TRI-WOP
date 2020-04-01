package com.doclink.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data

public class PostModel {
	

	


	
	public PostModel(Long id, String title, String description, String date, PostType type, UserModel user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.type = type;
		this.user = user;
	}
	public PostModel() {
		
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
	@OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
	private UserModel user;
}
