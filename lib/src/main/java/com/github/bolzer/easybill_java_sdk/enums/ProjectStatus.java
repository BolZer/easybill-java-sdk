package com.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum ProjectStatus {
    OPEN("OPEN"),

    DONE("DONE"),

    CANCEL("CANCEL");

    @NonNull
    private final String value;

    @JsonCreator
    ProjectStatus(@NonNull String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
