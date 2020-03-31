package com.doclink.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class CommentModel {
	

	public CommentModel(Long id, UserModel user, String date, String description) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
		this.description = description;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "user_id", nullable = false)
	    private UserModel user;
//	@OneToMany
//	private List<PostModel> post;
	private String date;
	private String description;

}
