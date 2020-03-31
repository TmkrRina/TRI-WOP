package com.doclink.service;

import com.doclink.validation.DoctorRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements IDoctorService {
    @Autowired
//    UserRepository userRepository; :Todo

    @Override
    public void createDoctor(DoctorRegistrationForm doctorRegistrationForm) {
//        :Todo use the UserRepository and finish the user saving implementation
//        User user = new User();
//        user.setEmail(userRegistrationForm.getEmail());
//        user.setPassword(userRegistrationForm.getPassword());
//        userRepository.save(user);
    }
}
