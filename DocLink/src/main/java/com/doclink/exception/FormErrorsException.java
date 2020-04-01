package com.doclink.exception;

import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FormErrorsException extends RuntimeException {

    public FormErrorsException(Errors errors) {
        super(errors.getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList()).toString());
    }
}
