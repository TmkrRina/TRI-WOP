package com.doclink.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.doclink.dto.NewDoctorDto;
import com.doclink.repositories.UserRepo;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
@Data
public class Doctor {
	public Doctor(NewDoctorDto doctor) {
		this.specialization = doctor.getSpecialization();
		this.experience = doctor.getExperience();
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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
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
