package com.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StockActivation {
    YES("YES"),

    NO("NO");

    private String value;

    StockActivation(String value) {
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
    public static StockActivation fromValue(String text) {
        for (StockActivation b : StockActivation.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new RuntimeException("Value for enum is invalid: " + text);
    }
}
