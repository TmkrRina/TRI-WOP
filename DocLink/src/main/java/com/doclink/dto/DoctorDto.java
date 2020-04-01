package com.doclink.dto;

import com.doclink.model.Doctor;

import lombok.Data;

@Data
public class DoctorDto {
	public DoctorDto(Doctor doc) {
		super();
		this.specialization = doc.getSpecialization();
		this.experience = doc.getExperience();
	}
	private String specialization;
	private String experience;

}
