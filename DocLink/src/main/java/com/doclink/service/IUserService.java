package com.doclink.service;

import com.doclink.model.User;
import com.doclink.model.VerificationToken;


public interface IUserService {
    User createUser(User user);

    User getUser(String verificationToken);

    void confirmUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String verificationToken);

}

