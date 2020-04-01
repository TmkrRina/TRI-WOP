package com.doclink.api;

import com.doclink.dto.UserDto;
import com.doclink.events.OnRegistrationCompleteEvent;
import com.doclink.model.Doctor;
import com.doclink.model.User;
import com.doclink.model.UserRole;
import com.doclink.service.DoctorService;
import com.doclink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@RestController
public class RegisterController {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @PostMapping ("/api/register")
    public @ResponseBody
    UserDto register (@Valid @RequestBody User user, BindingResult result, WebRequest request, Errors errors) {
        if(result.hasErrors()) {
            return new UserDto(user);
        } else {
            user.setRole(UserRole.ROLE_PATIENT);
            user = userService.createUser(user);
//            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user, request.getLocale(), request.getContextPath()));
            return new UserDto(user);
        }
    }

    @PostMapping("/api/register/doctor")
    public @ResponseBody String registerDoctor(@Valid @RequestBody Doctor doctor, BindingResult bindingResult, WebRequest request, Errors errors) {
        if(bindingResult.hasErrors()) {
//            :TODO Send a make sense message for form errors
            return "Form has errors";
        } else {
            doctor = userService.createDoctor(doctor);
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(doctor.getUser(), request.getLocale(), request.getContextPath()));
            return "Success";
        }
    }


}
