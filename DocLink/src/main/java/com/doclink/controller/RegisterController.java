package com.doclink.controller;

import com.doclink.validation.DoctorRegistrationForm;
import com.doclink.validation.UserRegistrationForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegisterController {
    //private final AtomicLong counter = new AtomicLong();

//    UserServiceImpl userService; :Todo add the UserService

    @PostMapping ("/api/register")
    public @ResponseBody String register (@Valid UserRegistrationForm userRegistrationForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
//            :TODO Send a make sense message for form errors
            return "Form has errors";
        } else {
//            UserServiceImpl.createUser(userRegistrationForm); :TODO write how to save the user logic by calling on the UserService
//            :Todo Send email confirmation mail to the user through the EmailNotificationServiceImpl background job
            return "Success";
        }
    }

    @PostMapping("/api/register/doctor")
    public @ResponseBody
    String register (@Valid DoctorRegistrationForm DoctorRegistrationForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
//            :TODO Send a make sense message for form errors
            return "Form has errors";
        } else {
//            DoctorServiceImpl.createDoctor(DoctorRegistrationForm); :TODO write how to save the user logic by calling on the UserService
//            :Todo Send email confirmation mail to the user through the EmailNotificationServiceImpl background job
            return "Success";
        }
    }


}
