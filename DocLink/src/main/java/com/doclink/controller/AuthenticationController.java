package com.doclink.controller;

import com.doclink.dto.JwtAuthDto;
import com.doclink.dto.JwtResponseDto;
import com.doclink.dto.RequestErrorsDto;
import com.doclink.exception.ApiError;
import com.doclink.exception.FormErrorsException;
import com.doclink.security.JwtTokenGenerator;
import com.doclink.service.DoclinkUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    DoclinkUserDetailService doclinkUserDetailService;

    @RequestMapping(value = "/api/auth", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@Valid @RequestBody JwtAuthDto jwtAuthDto, BindingResult result, Errors errors) throws Exception, FormErrorsException {

        if(result.hasErrors()) {
            throw new FormErrorsException(errors);
        }

        Authentication authentication = validateCredentials(jwtAuthDto.getEmail(), jwtAuthDto.getPassword());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = doclinkUserDetailService.loadUserByUsername(jwtAuthDto.getEmail());
        final String token = jwtTokenGenerator.generateToken(authentication);


        return ResponseEntity.ok(new JwtResponseDto(token, userDetails));

    }

    private Authentication validateCredentials(String email, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
