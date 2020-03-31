package com.doclink.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Data;
import javax.persistence.UniqueConstraint;




@Entity

@Data
public class UserModel {
	


	public UserModel(Long id, String fname, String lname, String email, String password, String gender, String state,
			String country, String profile_img, Boolean confirmed_email, UserRole role) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.state = state;
		this.country = country;
		this.profile_img = profile_img;
		this.confirmed_email = confirmed_email;
		this.role = role;
	
	}
	public UserModel() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fname;
	private String lname;
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	private String password;
	private String gender;
	private String state;
	private String country;
	private String profile_img;
	private Boolean confirmed_email;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@OneToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="user_id",nullable = false)
	private PostModel post;
	
	 @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private List<CommentModel> comments;
	
}
