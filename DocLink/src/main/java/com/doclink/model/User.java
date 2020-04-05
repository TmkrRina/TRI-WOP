package com.doclink.model;



import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;


import com.doclink.dto.NewUserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class User {
	


	public User(Long id, String fname, String lname, String email, String password, String gender, String state,
			String country, String profile_img, Boolean confirmed_email, UserRole role) {

		this.id = id;
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.state = state;
		this.country = country;
		this.profileImg = profile_img;
		this.confirmedEmail = confirmed_email;
		this.role = role;
	
	}
	public User() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	private String firstName;
	private String lastName;

	@CreationTimestamp
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	private LocalDateTime updateDateTime;

    public User(String email, String password) {
    	this.email = email;
    	this.password = password;
    }

	public User(NewUserDto user) {
    	setUsername(user.getEmail());
    	setFirstName(user.getFirstName());
    	setLastName(user.getLastName());
    	setCountry(user.getCountry());
    	setState(user.getState());
    	setGender(user.getGender());
    	setPassword(user.getPassword());
    	setEmail(user.getEmail());
	}


	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	@Column(name = "EMAIL", unique = true, nullable = false)
	@NotEmpty(message = "Please provide an email")
	@NotNull
	private String email;

	@Column(unique = true, nullable = false)
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotEmpty(message = "Please provide a password")
	@NotNull
	@JsonIgnore
	private String password;

	private String gender;
	private String state;
	private String country;
	private String profileImg;

	private Boolean confirmedEmail;
	@Enumerated(EnumType.STRING)
	private UserRole role;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public Long getId() {
		return id;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public Boolean getConfirmedEmail() {
		return confirmedEmail;
	}

	public void setConfirmedEmail(Boolean confirmedEmail) {
		this.confirmedEmail = confirmedEmail;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@OneToOne(mappedBy = "user")
	private Doctor doctor;

}
