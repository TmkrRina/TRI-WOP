package com.doclink.dto;

import org.springframework.validation.Errors;

import java.io.Serializable;
import java.util.Optional;

public class RequestErrorsDto implements Serializable {
    private Optional<Errors> errors;

    public RequestErrorsDto(Optional<Errors> errors) {
        this.errors = errors;
    }

    public Optional<Errors> getErrors() {
        return errors;
    }

    public void setErrors(Optional<Errors> errors) {
        this.errors = errors;
    }
}
