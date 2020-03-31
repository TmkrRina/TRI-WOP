package com.doclink.service;

import com.doclink.api.VerificationToken;
import com.doclink.validation.UserRegistrationForm;
import org.apache.catalina.User;

public interface IUserService {
    public abstract void createUser(UserRegistrationForm userRegistrationForm);

   // User registerNewUserAccount(UserDto accountDto)
       //     throws EmailExistsException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);
}

