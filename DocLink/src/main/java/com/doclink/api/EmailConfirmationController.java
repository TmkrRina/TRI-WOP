package com.doclink.api;

import com.doclink.model.Model;
import com.doclink.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;


@RestController
public class EmailConfirmationController {
@Autowired
    private IUserService service;

@GetMapping("/api/confirmEmail")
    public String confirmRegistration (WebRequest request, Model model, @RequestParam ("token") String token) {
    Locale locale = request.getLocale();
    VerificationToken verificationToken = service.getVerificationToken(token);
    if (verificationToken == null) {
        String message = messages.getMessage("auth.message.invalidToken", null, locale);
        model.addAttribute("message", message);
        return "redirect:/badUser.html?lang=" + locale.getLanguage();
    }

    //User user = verificationToken.getUser(); TODO
    Calendar cal = Calendar.getInstance();
    if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
        String messageValue = messages.getMessage("auth.message.expired", null, locale)
        model.addAttribute("message", messageValue);
        return "confirmation error message" + locale.getLanguage();
    }

    user.setEnabled(true);
    service.saveRegisteredUser(user);
    return "redirect:/login.html?lang=" + request.getLocale().getLanguage();
}


}}