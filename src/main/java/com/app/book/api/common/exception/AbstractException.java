package com.app.book.api.common.exception;

import com.app.book.api.common.code.ErrorCode;
import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.List;

public class AbstractException extends RuntimeException {

    @Getter
    private String code;
    @Getter
    private String msg;
    @Getter
    private ErrorCode errorCode;
    @Getter
    private List<FieldError> errors;

    private AbstractException(String msg) {
        super(msg);
        this.msg = msg;
    }

    protected AbstractException(String code, String msg) {
        this(msg);
        this.code = code;
    }

    protected AbstractException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    protected AbstractException(String code, String msg, Throwable e) {
        this(msg, e);
        this.code = code;
    }

    protected AbstractException(ErrorCode errorCode, String msg) {
        super(msg);
        this.code = errorCode.getCode();
        this.msg = msg;
        this.errorCode = errorCode;
    }

    protected AbstractException(ErrorCode errorCode, String code, String msg) {
        super(msg);
        this.code = code;
        this.errorCode = errorCode;
    }

    protected AbstractException(List<FieldError> fieldErrors) {
        this.errors = fieldErrors;
    }
}
