package com.doclink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.model.Doctor;
import com.doclink.repo.DoctorRepo;

import com.doclink.dto.DoctorDto;

@Service
public class DoctorService {
    @Autowired
    DoctorRepo doctor;

    public DoctorDto doctor(Doctor doc2) {
        Doctor doc = doctor.save(doc2);

        DoctorDto docDto = new DoctorDto(doc);


        return docDto;


    }
}
