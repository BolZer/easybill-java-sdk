package io.github.bolzer.easybill_java_sdk.enums;

import org.checkerframework.checker.nullness.qual.NonNull;

public enum SepaLocalInstrumentType {
    CORE("CORE"),

    COR1("COR1"),

    B2B("B2B");

    @NonNull
    private final String value;

    SepaLocalInstrumentType(@NonNull String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
