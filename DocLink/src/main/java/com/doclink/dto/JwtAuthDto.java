package com.doclink.dto;

import java.io.Serializable;

public class JwtAuthDto implements Serializable {
    private String password;
    private String email;

    public JwtAuthDto(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
