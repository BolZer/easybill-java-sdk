package com.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.bolzer.easybill_java_sdk.enums.DiscountType;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionGroupDiscountRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private PositionGroupDiscountRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static DiscountPositionGroupRequestBuilder builder() {
        return new DiscountPositionGroupRequestBuilder();
    }

    public static class DiscountPositionGroupRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public PositionGroupDiscountRequest build() {
            return new PositionGroupDiscountRequest(this.parameters);
        }

        public DiscountPositionGroupRequestBuilder customerId(long customerId) {
            this.parameters.put("customer_id", customerId);
            return this;
        }

        public DiscountPositionGroupRequestBuilder discount(float discount) {
            this.parameters.put("discount", discount);
            return this;
        }

        public DiscountPositionGroupRequestBuilder discountType(
            DiscountType discountType
        ) {
            this.parameters.put("discount_type", discountType);
            return this;
        }

        public DiscountPositionGroupRequestBuilder positionGroupId(
            long positionGroupId
        ) {
            this.parameters.put("position_group_id", positionGroupId);
            return this;
        }
    }
}
