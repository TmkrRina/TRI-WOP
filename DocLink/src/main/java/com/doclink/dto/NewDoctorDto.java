package com.doclink.dto;

import javax.validation.constraints.NotNull;

public class NewDoctorDto {
    @NotNull(message ="email is required")
    private String email;

    @NotNull(message ="password is required")
    private String password;

    @NotNull(message = "First name is required")
    private  String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Specialization is required")
    private String specialization;

    @NotNull(message = "Experience is required")
    private String experience;

    @NotNull(message = "Country required")
    private String country;

    private String state;

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

    public NewDoctorDto(String email, String password, String firstName, String lastName, String specialization, String experience, String country, String state) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.experience = experience;
        this.country = country;
        this.state = state;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
