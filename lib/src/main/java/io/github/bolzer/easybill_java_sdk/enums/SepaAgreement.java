package io.github.bolzer.easybill_java_sdk.enums;

import org.checkerframework.checker.nullness.qual.NonNull;

public enum SepaAgreement {
    NO_Mandate("NULL"),
    BASIC("BASIC"),
    COR1("COR1"),
    COMPANY("COMPANY");

    private final String value;

    SepaAgreement(@NonNull String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
