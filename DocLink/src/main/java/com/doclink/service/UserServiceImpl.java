package com.doclink.service;

import com.doclink.validation.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    //UserRepository userRepository;

    @Override
    public void createUser(UserRegistrationForm userRegistrationForm) {
//        :Todo use the UserRepository and finish the user saving implementation
//        User user = new User();
//        user.setEmail(userRegistrationForm.getEmail());
//        user.setPassword(userRegistrationForm.getPassword());
//        userRepository.save(user);
    }


}
