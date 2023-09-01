package com.github.bolzer.easybill_java_sdk.enums;

import org.checkerframework.checker.nullness.qual.NonNull;

public enum ServiceDateType {
    DEFAULT("DEFAULT"),
    SERVICE("SERVICE"),
    DELIVERY("DELIVERY");

    @NonNull
    private final String value;

    ServiceDateType(@NonNull String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
