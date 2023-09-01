package com.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.bolzer.easybill_java_sdk.enums.CostPriceChargeType;
import com.github.bolzer.easybill_java_sdk.enums.DiscountType;
import com.github.bolzer.easybill_java_sdk.enums.ItemType;
import com.github.bolzer.easybill_java_sdk.enums.PositionType;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class DocumentPositionRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private DocumentPositionRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static DocumentPositionRequestBuilder builder() {
        return new DocumentPositionRequestBuilder();
    }

    public static class DocumentPositionRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public DocumentPositionRequest build() {
            return new DocumentPositionRequest(this.parameters);
        }

        public DocumentPositionRequestBuilder positionId(long positionId) {
            this.parameters.put("position_id", positionId);
            return this;
        }

        public DocumentPositionRequestBuilder number(@NonNull String number) {
            this.parameters.put("number", number);
            return this;
        }

        public DocumentPositionRequestBuilder description(
            @NonNull String description
        ) {
            this.parameters.put("description", description);
            return this;
        }

        public DocumentPositionRequestBuilder quantity(float quantity) {
            this.parameters.put("quantity", quantity);
            return this;
        }

        public DocumentPositionRequestBuilder quantityStr(
            @NonNull String quantityStr
        ) {
            this.parameters.put("quantity_str", quantityStr);
            return this;
        }

        public DocumentPositionRequestBuilder unit(@NonNull String unit) {
            this.parameters.put("unit", unit);
            return this;
        }

        public DocumentPositionRequestBuilder type(
            @NonNull PositionType positionType
        ) {
            this.parameters.put("type", positionType);
            return this;
        }

        public DocumentPositionRequestBuilder itemType(
            @NonNull ItemType itemType
        ) {
            this.parameters.put("item_type", itemType);
            return this;
        }

        public DocumentPositionRequestBuilder singlePriceNet(
            float singlePriceNet
        ) {
            this.parameters.put("single_price_net", singlePriceNet);
            return this;
        }

        public DocumentPositionRequestBuilder singlePriceGross(
            float singlePriceGross
        ) {
            this.parameters.put("single_price_gross", singlePriceGross);
            return this;
        }

        public DocumentPositionRequestBuilder vatPercent(float vatPercent) {
            this.parameters.put("vat_percent", vatPercent);
            return this;
        }

        public DocumentPositionRequestBuilder discount(float discount) {
            this.parameters.put("discount", discount);
            return this;
        }

        public DocumentPositionRequestBuilder discountType(
            @NonNull DiscountType discountType
        ) {
            this.parameters.put("discount_type", discountType);
            return this;
        }

        public DocumentPositionRequestBuilder exportCost1(
            @NonNull String exportCost1
        ) {
            this.parameters.put("export_cost_1", exportCost1);
            return this;
        }

        public DocumentPositionRequestBuilder exportCost2(
            @NonNull String exportCost2
        ) {
            this.parameters.put("export_cost_2", exportCost2);
            return this;
        }

        public DocumentPositionRequestBuilder costPriceNet(float costPriceNet) {
            this.parameters.put("cost_price_net", costPriceNet);
            return this;
        }

        public DocumentPositionRequestBuilder costPriceCharge(
            float costPriceCharge
        ) {
            this.parameters.put("cost_price_charge", costPriceCharge);
            return this;
        }

        public DocumentPositionRequestBuilder costPriceChargeType(
            @NonNull CostPriceChargeType costPriceChargeType
        ) {
            this.parameters.put("cost_price_charge_type", costPriceChargeType);
            return this;
        }
    }
}
