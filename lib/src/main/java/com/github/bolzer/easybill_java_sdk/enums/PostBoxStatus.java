package com.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PostBoxStatus {
    WAITING("WAITING"),

    PREPARE("PREPARE"),

    ERROR("ERROR"),

    OK("OK"),

    PROCESSING("PROCESSING");

    private String value;

    PostBoxStatus(String value) {
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
    public static PostBoxStatus fromValue(String text) {
        for (PostBoxStatus b : PostBoxStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }

        throw new RuntimeException("Value for enum is invalid: " + text);
    }
}
