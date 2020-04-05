package com.doclink.controller;

//import com.doclink.model.Model;

import com.doclink.model.User;
import com.doclink.model.VerificationToken;
import com.doclink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Calendar;
import java.util.Locale;


@RestController
public class EmailConfirmationController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messages;

    @GetMapping("/api/confirmEmail")
    public String confirmRegistration(@RequestParam("token") String token, WebRequest request) {
        Locale locale = request.getLocale();
        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            String message = messages.getMessage("auth.message.invalidToken", null, locale);
//        model.addAttribute("message", message);
//        return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = messages.getMessage("auth.message.expired", null, locale);
//        model.addAttribute("message", messageValue);
//        return "confirmation error message" + locale.getLanguage();
        }

        userService.confirmUser(user);
        return "confirm done at" + request.getLocale().getLanguage();
    }


}