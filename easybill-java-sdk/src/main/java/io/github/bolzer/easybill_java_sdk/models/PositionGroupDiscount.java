package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bolzer.easybill_java_sdk.enums.DiscountType;
import lombok.Getter;
import org.checkerframework.checker.nullness.qual.NonNull;

@Getter
public final class PositionGroupDiscount extends Discount {

    @NonNull
    final Long positionGroupId;

    public PositionGroupDiscount(
        @JsonProperty("id") @NonNull Long id,
        @JsonProperty("customer_id") @NonNull Long customerId,
        @JsonProperty("discount") float discount,
        @JsonProperty("discount_type") @NonNull DiscountType discountType,
        @JsonProperty("position_group_id") @NonNull Long positionGroupId
    ) {
        super(id, customerId, discount, discountType);
        this.positionGroupId = positionGroupId;
    }
}
