package com.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum BudgetNotifyFrequency {
    ALWAYS("ALWAYS"),

    ONCE("ONCE"),

    NEVER("NEVER ");

    @NonNull
    private final String value;

    @JsonCreator
    BudgetNotifyFrequency(@NonNull String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
