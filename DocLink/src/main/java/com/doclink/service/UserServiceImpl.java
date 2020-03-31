package com.doclink.service;

import com.doclink.api.VerificationToken;
import com.doclink.api.VerificationTokenRepository;
import com.doclink.service.notifications.IEmailNotificationService;
import com.doclink.validation.UserRegistrationForm;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService, IEmailNotificationService {
//    @Autowired
    // private UserRepository userRepository; Todo UserRepo

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Override
    public User registerNewUserAccount(UserDto userDto) throws EmailExistsException {

        if (emailExist(userDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + userDto.getEmail());
        }

        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        user.setRole(new Role(Integer.valueOf(1), user));
        return repository.save(user);
    }

    private boolean emailExist(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public User getUser(String verificationToken) {
        User user = tokenRepository.findByToken(verificationToken).getUser();
        return user;
    }

    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    @Override
    public void saveRegisteredUser(User user) {
        repository.save(user);
    }

    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }


    @Override
    public void createUser(UserRegistrationForm userRegistrationForm) {
//        :Todo use the UserRepository and finish the user saving implementation
//        User user = new User();
//        user.setEmail(userRegistrationForm.getEmail());
//        user.setPassword(userRegistrationForm.getPassword());
//        userRepository.save(user);
    }

    @Override
    public void sendEmailConfirmation(/* User user Todo*/) {
//        Todo send Email confirmation to user
    }
}
