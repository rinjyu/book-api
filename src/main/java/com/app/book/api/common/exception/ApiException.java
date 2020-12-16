package com.app.book.api.common.exception;

public class ApiException extends AbstractException {

    public ApiException(String code, String message) {
        super(code, message);
    }

    public ApiException(String code, String message, Throwable e) {
        super(code, message, e);
    }
}