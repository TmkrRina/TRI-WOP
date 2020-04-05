package com.doclink.security;


import com.doclink.service.DoclinkUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Finally, Let’s write the JWTAuthenticationFilter to get the JWT token from the request,
 * validate it, load the user associated with the token, and pass it to Spring Security -
 * <p>
 * Documentation says org.springframework.web.filter.OncePerRequestFilter
 * "guarantees to be just executed once per request".
 */

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;
    @Autowired
    private DoclinkUserDetailService doclinkUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && jwtTokenGenerator.validateToken(jwt)) {
                Long userId = jwtTokenGenerator.getUserIdFromJWT(jwt);

                /*
                    Note that you could also encode the user's username and roles inside JWT claims
                    and create the UserDetails object by parsing those claims from the JWT.
                    That would avoid the following database hit. It's completely up to you.
                 */
                UserDetails userDetails = doclinkUserDetailService.loadUserById(userId);
                System.out.printf("+++++++++++++++++++++++++++++++++++++%n%s%n+++++++++++++++++++++++++++++++++++++", userDetails);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
