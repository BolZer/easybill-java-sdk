package com.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum DocumentFileType {
    DEFAULT("default"),
    ZUGFERD1("zugferd1"),
    ZUGFERD2("zugferd2"),
    XRECHNUNG("xrechnung"),
    XRECHNUNG_XML("xrechnung_xml");

    @NonNull
    private final String value;

    @JsonCreator
    DocumentFileType(@NonNull String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }
}
