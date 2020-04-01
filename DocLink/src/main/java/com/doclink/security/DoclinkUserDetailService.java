package com.doclink.security;

import com.doclink.exception.ResourceNotFoundException;
import com.doclink.model.UserModel;
import com.doclink.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoclinkUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel userModel = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + email)
                );

        return DoclinkSecurityUser.create(userModel);
    }

    // The following method is defined for JWTAuthenticationFilter
    // To load the user details associated with a given token
    // We should see that
    @Transactional
    public UserDetails loadUserById(Long id) {
        UserModel user = userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No User with this not found ", "id", id)
        );

        return DoclinkSecurityUser.create(user);
    }
}
