package com.app.book.api.common.entity;

import com.app.book.api.common.code.ErrorCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ErrorEntity {

    private String code;
    private String message;
    private List<FieldErrorEntity> fieldErrors;

    public ErrorEntity(ErrorCode code, String message) {
        this.code = code.getCode();
        this.message = message;
    }

    public ErrorEntity(ErrorCode code, String message, List<FieldError> fieldErrors) {
        this.code = code.getCode();
        this.message = message;
        this.fieldErrors = fieldErrors.stream()
                .map(error -> new FieldErrorEntity(
                        error.getObjectName()
                        , error.getField()
                        , StringUtils.isEmpty(error.getDefaultMessage()) ? error.getCode() : error.getDefaultMessage()
                        )
                )
                .collect(Collectors.toList());
    }
}
