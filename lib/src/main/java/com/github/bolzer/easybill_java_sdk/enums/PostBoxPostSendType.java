package com.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PostBoxPostSendType {
    STANDARD("post_send_type_standard"),

    REGISTERED("post_send_type_registered"),

    REGISTERED_AND_PERSONAL("post_send_type_registered_and_personal"),

    REGISTERED_AND_RECEIPT("post_send_type_registered_and_receipt"),

    REGISTERED_THROWIN("post_send_type_registered_throwin"),

    PRIO("post_send_type_prio");

    private String value;

    PostBoxPostSendType(String value) {
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
    public static PostBoxPostSendType fromValue(String text) {
        for (PostBoxPostSendType b : PostBoxPostSendType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }

        throw new RuntimeException("Value for enum is invalid: " + text);
    }
}
