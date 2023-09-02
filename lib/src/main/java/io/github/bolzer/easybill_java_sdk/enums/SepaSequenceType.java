package io.github.bolzer.easybill_java_sdk.enums;

public enum SepaSequenceType {
    FRST("FRST"),

    OOFF("OOFF"),

    FNAL("FNAL"),

    RCUR("RCUR");

    private String value;

    SepaSequenceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
