package com.app.book.api.common.entity;

import com.app.book.api.common.code.SuccessCode;
import lombok.Data;

@Data
public class SuccessEntity {

    private String code;
    private String message;

    public SuccessEntity(SuccessCode code, String message) {
        this.code = code.getCode();
        this.message = message;
    }

}
