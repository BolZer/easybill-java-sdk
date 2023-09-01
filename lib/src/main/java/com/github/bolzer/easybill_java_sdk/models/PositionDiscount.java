package com.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.bolzer.easybill_java_sdk.enums.DiscountType;
import lombok.Getter;
import org.checkerframework.checker.nullness.qual.NonNull;

@Getter
public final class PositionDiscount extends Discount {

    final long positionId;

    public PositionDiscount(
        @JsonProperty("id") @NonNull Long id,
        @JsonProperty("customer_id") @NonNull Long customerId,
        @JsonProperty("discount") float discount,
        @JsonProperty("discount_type") @NonNull DiscountType discountType,
        @JsonProperty("position_id") long positionId
    ) {
        super(id, customerId, discount, discountType);
        this.positionId = positionId;
    }
}
