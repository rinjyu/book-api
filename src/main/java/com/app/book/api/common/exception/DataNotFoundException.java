package com.app.book.api.common.exception;

public class DataNotFoundException extends AbstractException {

    public DataNotFoundException(String code, String message) {
        super(code, message);
    }

    public DataNotFoundException(String code, String message, Throwable e) {
        super(code, message, e);
    }
}
