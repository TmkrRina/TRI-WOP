package com.doclink.dto;

import com.doclink.model.User;
import com.doclink.model.UserRole;

import lombok.Data;

@Data
public class UserDto {
	private String firstName;
	private String lastName;
	private String email;
	
	private String gender;
	private String state;
	private String country;
	private String profileImg;
	private Boolean confirmedEmail;
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

	public UserDto() {}
	
	public UserDto(User user) {
		this.firstName = user.getFirstName();
		this.lastName=user.getLastName();
		this.email = user.getEmail();
		this.gender=user.getGender();
		this.state = user.getState();
		this.country=user.getCountry();
		this.profileImg = user.getProfileImg();
		this.confirmedEmail=user.getConfirmedEmail();
		this.role = user.getRole();
		
	}
}