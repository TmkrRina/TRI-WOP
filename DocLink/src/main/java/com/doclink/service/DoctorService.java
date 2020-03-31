package com.doclink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.model.Doctor;
import com.doclink.repo.DoctorRepo;

import dto.DoctorDTO;

@Service
public class DoctorService {
	@Autowired
	DoctorRepo doctor;
	public DoctorDTO doctor(Doctor doc2) {
		Doctor doc = doctor.save(doc2);
		
		DoctorDTO docDto = new DoctorDTO(doc);
		
		
		return docDto;

		
	}
}
