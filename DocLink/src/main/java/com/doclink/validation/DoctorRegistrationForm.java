package com.doclink.validation;

import javax.validation.constraints.NotNull;

public class DoctorRegistrationForm {
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private UserRole role;
    @NotNull
    private String specialization;
    @NotNull
    private String country;
    @NotNull
    private String state;
    @NotNull
    private String experience;

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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}