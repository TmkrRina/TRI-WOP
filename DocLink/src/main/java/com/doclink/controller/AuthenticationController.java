package com.doclink.controller;

import com.doclink.dto.JwtAuthDto;
import com.doclink.dto.JwtResponseDto;
import com.doclink.security.JwtTokenGenerator;
import com.doclink.service.DoclinkUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<?> authenticate(@Valid @RequestBody JwtAuthDto jwtAuthDto, BindingResult result, Errors errors) throws Exception {

        Authentication authentication = validateCredentials(jwtAuthDto.getEmail(), jwtAuthDto.getPassword());

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
            System.out.printf("+++++++++++++++++++++++++++++++++++++%n%s%n+++++++++++++++++++++++++++++++++++++", e);
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
