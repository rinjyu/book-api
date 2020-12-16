package com.app.book.api.common.response;

import com.app.book.api.common.code.ErrorCode;
import com.app.book.api.common.entity.ErrorEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class ApiError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime localDateTime;

    private String status = ErrorCode.FAIL.getCode();

    private String message = ErrorCode.FAIL.getMessage();

    private ErrorEntity error;

    private ApiError(){
        localDateTime = LocalDateTime.now();
    }

    public ApiError(ErrorCode code, String message) {
        this();
        error = new ErrorEntity(code, message);
    }

    public ApiError(ErrorCode code, Throwable e) {
        this();
        error = new ErrorEntity(code, e.getLocalizedMessage());
    }

    public ApiError(ErrorCode code, String message, List<FieldError> fieldErrors) {
        this();
        error = new ErrorEntity(code, message, fieldErrors);
    }

}
