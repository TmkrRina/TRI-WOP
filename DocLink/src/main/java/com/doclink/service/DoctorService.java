package com.doclink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doclink.repositories.DoctorRepo;

@Service
public class DoctorService {
    @Autowired
    DoctorRepo doctor;

}
