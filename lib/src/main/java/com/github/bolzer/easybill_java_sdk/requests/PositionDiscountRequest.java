package com.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.bolzer.easybill_java_sdk.enums.DiscountType;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class PositionDiscountRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private PositionDiscountRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static DiscountPositionRequestBuilder builder() {
        return new DiscountPositionRequestBuilder();
    }

    public static class DiscountPositionRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public PositionDiscountRequest build() {
            return new PositionDiscountRequest(this.parameters);
        }

        public DiscountPositionRequestBuilder customerId(long customerId) {
            this.parameters.put("customer_id", customerId);
            return this;
        }

        public DiscountPositionRequestBuilder discount(float discount) {
            this.parameters.put("discount", discount);
            return this;
        }

        public DiscountPositionRequestBuilder discountType(
            DiscountType discountType
        ) {
            this.parameters.put("discount_type", discountType);
            return this;
        }

        public DiscountPositionRequestBuilder positionId(long positionId) {
            this.parameters.put("position_id", positionId);
            return this;
        }
    }
}
