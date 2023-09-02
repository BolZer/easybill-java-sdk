package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bolzer.easybill_java_sdk.enums.DiscountType;
import lombok.Getter;
import org.checkerframework.checker.nullness.qual.NonNull;

@Getter
public abstract sealed class Discount
    permits PositionDiscount, PositionGroupDiscount {

    @JsonProperty("id")
    @NonNull
    final Long id;

    @JsonProperty("customer_id")
    @NonNull
    final Long customerId;

    @JsonProperty("discount")
    final float discount;

    @JsonProperty("discount_type")
    @NonNull
    final DiscountType discountType;

    public Discount(
        @NonNull Long id,
        @NonNull Long customerId,
        float discount,
        @NonNull DiscountType discountType
    ) {
        this.id = id;
        this.customerId = customerId;
        this.discount = discount;
        this.discountType = discountType;
    }
}
