package com.doclink.exception;

import org.springframework.validation.Errors;

public class ResourceErrorException extends RuntimeException {

    public ResourceErrorException(Throwable ex) {
        super(ex.getLocalizedMessage());
    }

}
