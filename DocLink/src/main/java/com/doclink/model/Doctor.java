package com.doclink.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.doclink.dto.NewDoctorDto;

import lombok.Data;

@Entity
@Data
public class Doctor {
	public Doctor(NewDoctorDto doctor,User user) {
		this.specialization = doctor.getSpecialization();
		this.experience = doctor.getExperience();
		this.user=user;
	
	}

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



	public  Doctor() { }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String specialization;
	private String experience;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	public Doctor(User user, String specialization, String experience) {
		this.user = user;
		this.specialization = specialization;
		this.experience = experience;
	}

	@CreationTimestamp
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
}
