package com.doclink.validation;

import javax.validation.constraints.NotNull;

public class UserRegistrationForm {
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private UserRole role;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(UserRole role) {
        role = role;
    }

    public UserRole getRole() {
        return role;
    }
}
