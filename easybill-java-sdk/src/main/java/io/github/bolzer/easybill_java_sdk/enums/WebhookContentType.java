package io.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum WebhookContentType {
    FORM("form"),

    JSON("json");

    private String value;

    WebhookContentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static WebhookContentType fromValue(String text) {
        for (WebhookContentType b : WebhookContentType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new RuntimeException("Value for enum is invalid: " + text);
    }
}
