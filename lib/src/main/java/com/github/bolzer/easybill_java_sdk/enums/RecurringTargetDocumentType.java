package com.github.bolzer.easybill_java_sdk.enums;

import org.checkerframework.checker.nullness.qual.NonNull;

public enum RecurringTargetDocumentType {
    INVOICE("INVOICE"),

    CREDIT("CREDIT"),

    ORDER("ORDER"),

    OFFER("OFFER");

    @NonNull
    private final String value;

    RecurringTargetDocumentType(@NonNull String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
