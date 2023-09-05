package io.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class CustomerGroupRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private CustomerGroupRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static CustomerGroupRequestBuilder builder() {
        return new CustomerGroupRequestBuilder();
    }

    public static class CustomerGroupRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public CustomerGroupRequest build() {
            return new CustomerGroupRequest(this.parameters);
        }

        public CustomerGroupRequestBuilder name(@NonNull String name) {
            this.parameters.put("name", name);
            return this;
        }

        public CustomerGroupRequestBuilder description(
            @NonNull String description
        ) {
            this.parameters.put("description", description);
            return this;
        }

        public CustomerGroupRequestBuilder number(@NonNull String number) {
            this.parameters.put("number", number);
            return this;
        }
    }
}
