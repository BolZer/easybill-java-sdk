package io.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum VatOption {
    NSTB("nStb"),

    NSTBUSTID("nStbUstID"),

    NSTBNONEUSTID("nStbNoneUstID"),

    NSTBIM("nStbIm"),

    REVC("revc"),

    IG("IG"),

    AL("AL"),

    SSTFR("sStfr"),

    SMALLBUSINESS("smallBusiness");

    @NonNull
    private final String value;

    @JsonCreator
    VatOption(@NonNull String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }
}
