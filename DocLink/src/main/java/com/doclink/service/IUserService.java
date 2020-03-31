package com.doclink.service;

import com.doclink.validation.UserRegistrationForm;

public interface IUserService {
    public abstract void createUser(UserRegistrationForm userRegistrationForm);
}
