package com.app.book.api.common.handler;

import com.app.book.api.common.code.ErrorCode;
import com.app.book.api.common.exception.ApiException;
import com.app.book.api.common.exception.DataNotFoundException;
import com.app.book.api.common.exception.DuplicateDataException;
import com.app.book.api.common.exception.InvalidFieldException;
import com.app.book.api.common.response.ApiError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ApiError> handleAll(Exception ex) {

        ApiError apiError = new ApiError(ErrorCode.UNKNOWN_ERROR, ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ InvalidFieldException.class })
    public ResponseEntity<ApiError> handleInvalidField(InvalidFieldException ex) {

        ApiError apiError = new ApiError(ErrorCode.INVALID_FIELD, ErrorCode.INVALID_FIELD.getMessage(), ex.getErrors());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ DataNotFoundException.class })
    public ResponseEntity<ApiError> handleDataNotFound(DataNotFoundException ex) {

        ApiError apiError = new ApiError(ErrorCode.NOT_FOUND, ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ DuplicateDataException.class })
    public ResponseEntity<ApiError> handleDuplicateData(DuplicateDataException ex) {

        ApiError apiError = new ApiError(ErrorCode.DUPLICATE_DATA, ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ ApiException.class })
    public ResponseEntity<ApiError> handleApiException(DataNotFoundException ex) {

        ApiError apiError = new ApiError(ErrorCode.UNKNOWN_ERROR, ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
