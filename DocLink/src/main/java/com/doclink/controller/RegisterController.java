package com.doclink.controller;

import javax.validation.Valid;

import com.doclink.dto.NewDoctorDto;
import com.doclink.dto.NewUserDto;
import com.doclink.exception.FormErrorsException;
import com.doclink.exception.ResourceErrorException;
import com.doclink.model.UserRole;
import com.doclink.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import com.doclink.events.OnRegistrationCompleteEvent;
import com.doclink.model.Doctor;
import com.doclink.model.User;
import com.doclink.service.DoctorService;
import com.doclink.service.UserService;

@RestController
public class RegisterController {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/api/register")
    public User register(@Valid @RequestBody NewUserDto user, BindingResult result, Errors errors) throws FormErrorsException {
        if (result.hasErrors()) {
            throw new FormErrorsException(errors);
        } else {
            User newUser = new User(user.getEmail(), user.getPassword());
            newUser = userService.createUser(newUser);
//            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user, request.getLocale(), request.getContextPath()));
            return newUser;
        }
    }

    @PostMapping("/api/register/doctor")
    public Doctor registerDoctor(@Valid @RequestBody NewDoctorDto doctor, BindingResult bindingResult, Errors errors) throws FormErrorsException {
        if (bindingResult.hasErrors()) {
            throw new FormErrorsException(errors);
        } else {
            try {
                User user = new User();
                user.setConfirmedEmail(false);
                user.setEmail(doctor.getEmail());
                user.setPassword(doctor.getPassword());
                user.setFirstName(doctor.getFirstName());
                user.setLastName(doctor.getLastName());
                user.setCountry(doctor.getCountry());
                user.setState(doctor.getState());
                user.setUsername(doctor.getEmail());
                user.setRole(UserRole.ROLE_DOCTOR);
                Doctor newDoctor = new Doctor(doctor);
                newDoctor.setUser(user);
                newDoctor = userService.createDoctor(newDoctor);
//            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(doctor.getUser(), request.getLocale(), request.getContextPath()));
                return newDoctor;

            } catch (Exception ex) {
                throw new ResourceErrorException(ex);

            }
        }
    }


}
