package com.doclink.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Doctor {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Doctor(Long id, String specialization, String experience, User user) {
		this.id = id;
		this.specialization = specialization;
		this.experience = experience;
		this.user = user;
	}

	public  Doctor() { }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String specialization;
	private String experience;

	@NotNull
	@NotEmpty(message = "User model is required")
	@OneToOne
	@JoinColumn(name="user")
	private User user;

	public Doctor(User user, String specialization, String experience) {
		this.user = user;
		this.specialization = specialization;
		this.experience = experience;
	}
}
