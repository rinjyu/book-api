package com.app.book.api.common.entity;

import lombok.Data;

@Data
public class FieldErrorEntity {

    private String object;
    private String field;
    private String reason;

    public FieldErrorEntity(String object, String field, String reason) {
        this.object = object;
        this.field = field;
        this.reason = reason;
    }
}
