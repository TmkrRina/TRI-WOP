package com.doclink.repositories;

import org.springframework.data.repository.CrudRepository;

import com.doclink.model.Doctor;

public interface DoctorRepo extends CrudRepository<Doctor, Long>{

}
