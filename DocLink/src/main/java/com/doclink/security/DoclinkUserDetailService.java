package com.doclink.security;

import com.doclink.exception.ResourceNotFoundException;
import com.doclink.model.UserModel;
import com.doclink.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoclinkUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo doclinkUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        UserModel doclinkUser = doclinkUserRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );

        return DoclinkUserPrincipal.create(doclinkUser);
    }

    // The following method is defined for JWTAuthenticationFilter
    // To load the user details associated with a given token
    // We should see that
    @Transactional
    public UserDetails loadUserById(Long id) {
        UserModel user = doclinkUserRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No User with this not found ", "id", id)
        );

        return DoclinkUserPrincipal.create(user);
    }
}
