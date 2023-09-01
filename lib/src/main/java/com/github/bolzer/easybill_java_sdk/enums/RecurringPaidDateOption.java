package com.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum RecurringPaidDateOption {
    CREATED_DATE("created_date"),

    DUE_DATE("due_date"),

    NEXT_VALID_DATE("next_valid_date");

    @NonNull
    private final String value;

    @JsonCreator
    RecurringPaidDateOption(@NonNull String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }
}
