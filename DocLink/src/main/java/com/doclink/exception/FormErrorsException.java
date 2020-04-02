package com.doclink.exception;

import java.util.stream.Collectors;

import org.springframework.validation.Errors;

public class FormErrorsException extends RuntimeException {

    public FormErrorsException(Errors errors) {
        super(errors.getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList()).toString());
    }
}
