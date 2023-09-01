package com.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PostBoxType {
    FAX("FAX"),

    EMAIL("EMAIL"),

    POST("POST");

    private String value;

    PostBoxType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static PostBoxType fromValue(String text) {
        for (PostBoxType b : PostBoxType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }

        throw new RuntimeException("Value for enum is invalid: " + text);
    }
}
