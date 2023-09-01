package com.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class SerialNumberRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private SerialNumberRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static SerialNumberRequestBuilder builder() {
        return new SerialNumberRequestBuilder();
    }

    public static class SerialNumberRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public SerialNumberRequest build() {
            return new SerialNumberRequest(this.parameters);
        }

        public SerialNumberRequestBuilder serialNumber(
            @NonNull String serialNumber
        ) {
            this.parameters.put("serial_number", serialNumber);
            return this;
        }

        public SerialNumberRequestBuilder positionId(long positionId) {
            this.parameters.put("position_id", positionId);
            return this;
        }
    }
}
