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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class Authentication {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    DoclinkUserDetailService doclinkUserDetailService;

    @RequestMapping(value = "/api/auth", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody JwtAuthDto jwtAuthDto) throws Exception {
        validateCredentials(jwtAuthDto.getEmail(), jwtAuthDto.getPassword());

        final UserDetails userDetails = doclinkUserDetailService.loadUserByUsername(jwtAuthDto.getEmail());

        final String token = jwtTokenGenerator.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponseDto(token, userDetails));

    }

    private void validateCredentials(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
