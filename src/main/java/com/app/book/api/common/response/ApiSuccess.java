package com.app.book.api.common.response;

import com.app.book.api.common.code.SuccessCode;
import com.app.book.api.common.entity.SuccessEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiSuccess<T> {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime localDateTime;

    private String status = SuccessCode.SUCCESS.getCode();

    private String message = SuccessCode.SUCCESS.getMessage();

    private SuccessEntity success;

    private T data;

    public ApiSuccess(){
        localDateTime = LocalDateTime.now();
    }

    public ApiSuccess(SuccessCode code){
        this();
        success = new SuccessEntity(code, code.getMessage());
    }
}
