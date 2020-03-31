package com.doclink.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Finally, Let’s write the JWTAuthenticationFilter to get the JWT token from the request,
 * validate it, load the user associated with the token, and pass it to Spring Security -
 *
 * Documentation says org.springframework.web.filter.OncePerRequestFilter
 * "guarantees to be just executed once per request".
 */

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;
    @Autowired
    private DoclinkUserDetailService doclinkUserDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }
}
