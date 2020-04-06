package com.doclink.service;

import com.doclink.model.Doctor;
import com.doclink.model.User;
import com.doclink.model.UserRole;
import com.doclink.model.VerificationToken;
import com.doclink.repositories.DoctorRepo;
import com.doclink.repositories.UserRepo;
import com.doclink.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class UserService implements IUserService, IDoctorService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    private boolean emailExist(String email) {
        Optional<User> user = userRepo.findByEmail(email);
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


    public void confirmUser(User user) {
        user.setConfirmedEmail(true);
        userRepo.save(user);
    }

    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }

    @Override
    public User createUser(User user) {
        user.setRole(UserRole.ROLE_PATIENT);
        user.setConfirmedEmail(false);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return user;
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {

        doctorRepo.save(doctor);
        return doctor;
    }
}
