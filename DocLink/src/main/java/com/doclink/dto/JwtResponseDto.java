package com.doclink.dto;

import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

public class JwtResponseDto implements Serializable {
    private String token;
    private UserDetails user;

    public JwtResponseDto() {
    }

    public JwtResponseDto(String token, UserDetails userDetails) {
        this.token = token;
        this.user = userDetails;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public UserDetails getUser() {
        return user;
    }
}
