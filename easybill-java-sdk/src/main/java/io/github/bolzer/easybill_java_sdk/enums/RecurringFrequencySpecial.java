package io.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum RecurringFrequencySpecial {
    EMPTY(""),
    LASTDAYOFMONTH("LASTDAYOFMONTH");

    @NonNull
    private final String value;

    @JsonCreator
    RecurringFrequencySpecial(@NonNull String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }
}
