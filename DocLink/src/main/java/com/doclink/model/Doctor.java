package com.doclink.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Doctor {
	
	public Doctor(Long id, String specialization, String experience, User user) {
		super();
		this.id = id;
		this.specialization = specialization;
		this.experience = experience;
		this.user = user;
	}
	public  Doctor() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
private String specialization;
private String experience;
@OneToOne
@JoinColumn(name="user")
private User user;

}
