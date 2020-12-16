package com.app.book.api.common.exception;

import org.springframework.validation.FieldError;

import java.util.List;

public class InvalidFieldException extends AbstractException {

    public InvalidFieldException(List<FieldError> fieldErrors) {
        super(fieldErrors);
    }
}
