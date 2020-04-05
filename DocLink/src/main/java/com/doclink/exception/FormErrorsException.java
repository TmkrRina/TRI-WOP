package com.doclink.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.Errors;

public class FormErrorsException extends RuntimeException {
    private Errors errors;

    public Errors getErrors() {
        return errors;
    }

    public FormErrorsException(Errors errors) {
        super("Form errors");
        this.errors = errors;
    }

}
