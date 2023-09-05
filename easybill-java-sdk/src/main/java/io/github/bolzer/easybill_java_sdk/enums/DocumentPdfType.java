package io.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum DocumentPdfType {
    DEFAULT("default"),
    ZUGFERD_1("zugferd1"),
    ZUGFERD_2_2("zugferd2_2"),
    XRECHNUNG_2_1_XML("xrechnung2_1_xml"),
    XRECHNUNG_2_2_XML("xrechnung2_2_xml");

    @NonNull
    private final String value;

    @JsonCreator
    DocumentPdfType(@NonNull String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }
}
