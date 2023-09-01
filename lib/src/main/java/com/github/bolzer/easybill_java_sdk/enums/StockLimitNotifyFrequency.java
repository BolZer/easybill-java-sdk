package com.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StockLimitNotifyFrequency {
    ALWAYS("ALWAYS"),

    ONCE("ONCE");

    private String value;

    StockLimitNotifyFrequency(String value) {
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
    public static StockLimitNotifyFrequency fromValue(String text) {
        for (StockLimitNotifyFrequency b : StockLimitNotifyFrequency.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new RuntimeException("Value for enum is invalid: " + text);
    }
}
