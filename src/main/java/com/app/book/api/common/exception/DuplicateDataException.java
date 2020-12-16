package com.app.book.api.common.exception;

public class DuplicateDataException extends AbstractException {

    public DuplicateDataException(String code, String message) {
        super(code, message);
    }

    public DuplicateDataException(String code, String message, Throwable e) {
        super(code, message, e);
    }
}
