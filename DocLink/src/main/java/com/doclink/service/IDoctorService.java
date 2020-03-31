package com.doclink.service;

import com.doclink.validation.DoctorRegistrationForm;

public interface IDoctorService {
    public abstract void createDoctor(DoctorRegistrationForm doctorRegistrationForm);
}
