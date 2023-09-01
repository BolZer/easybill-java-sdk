package com.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class PositionGroupRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private PositionGroupRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static PositionGroupRequestBuilder builder() {
        return new PositionGroupRequestBuilder();
    }

    public static class PositionGroupRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public PositionGroupRequest build() {
            return new PositionGroupRequest(this.parameters);
        }

        public PositionGroupRequestBuilder name(@NonNull String name) {
            this.parameters.put("name", name);
            return this;
        }

        public PositionGroupRequestBuilder description(
            @NonNull String description
        ) {
            this.parameters.put("description", description);
            return this;
        }

        public PositionGroupRequestBuilder number(@NonNull String number) {
            this.parameters.put("number", number);
            return this;
        }
    }
}
