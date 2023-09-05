package io.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PriceType {
    GROSS("BRUTTO"),

    NET("NETTO");

    private String value;

    PriceType(String value) {
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
    public static PriceType fromValue(String text) {
        for (PriceType b : PriceType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new RuntimeException("Value for enum is invalid: " + text);
    }
}
