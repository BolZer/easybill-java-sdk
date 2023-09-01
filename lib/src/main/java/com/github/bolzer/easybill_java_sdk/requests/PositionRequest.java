package com.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.bolzer.easybill_java_sdk.enums.ItemType;
import com.github.bolzer.easybill_java_sdk.enums.PriceType;
import com.github.bolzer.easybill_java_sdk.enums.StockActivation;
import com.github.bolzer.easybill_java_sdk.enums.StockLimitNotifyFrequency;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class PositionRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private PositionRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    //TODO: Separate Builder into dedicated builders for Type Product, Text, Service and Undefined
    // There are currently fields available in the builder which are only available for specific item types
    // Like stock management makes no sense for service positions
    public static PositionRequestBuilder builder() {
        return new PositionRequestBuilder();
    }

    public static class PositionRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public PositionRequest build() {
            return new PositionRequest(this.parameters);
        }

        public PositionRequestBuilder number(@NonNull String number) {
            this.parameters.put("number", number);
            return this;
        }

        public PositionRequestBuilder description(@NonNull String description) {
            this.parameters.put("description", description);
            return this;
        }

        public PositionRequestBuilder type(@NonNull ItemType type) {
            this.parameters.put("type", type);
            return this;
        }

        public PositionRequestBuilder priceType(@NonNull PriceType priceType) {
            this.parameters.put("price_type", priceType.toString());
            return this;
        }

        public PositionRequestBuilder unit(@NonNull String unit) {
            this.parameters.put("unit", unit);
            return this;
        }

        public PositionRequestBuilder note(@NonNull String note) {
            this.parameters.put("note", note);
            return this;
        }

        public PositionRequestBuilder documentNote(
            @NonNull String documentNote
        ) {
            this.parameters.put("document_note", documentNote);
            return this;
        }

        public PositionRequestBuilder salePrice(long salePrice) {
            this.parameters.put("sale_price", salePrice);
            return this;
        }

        public PositionRequestBuilder salePrice2(long salePrice2) {
            this.parameters.put("sale_price2", salePrice2);
            return this;
        }

        public PositionRequestBuilder salePrice3(long salePrice3) {
            this.parameters.put("sale_price3", salePrice3);
            return this;
        }

        public PositionRequestBuilder salePrice4(long salePrice4) {
            this.parameters.put("sale_price4", salePrice4);
            return this;
        }

        public PositionRequestBuilder salePrice5(long salePrice5) {
            this.parameters.put("sale_price5", salePrice5);
            return this;
        }

        public PositionRequestBuilder salePrice6(long salePrice6) {
            this.parameters.put("sale_price6", salePrice6);
            return this;
        }

        public PositionRequestBuilder salePrice7(long salePrice7) {
            this.parameters.put("sale_price7", salePrice7);
            return this;
        }

        public PositionRequestBuilder salePrice8(long salePrice8) {
            this.parameters.put("sale_price8", salePrice8);
            return this;
        }

        public PositionRequestBuilder salePrice9(long salePrice9) {
            this.parameters.put("sale_price9", salePrice9);
            return this;
        }

        public PositionRequestBuilder salePrice10(long salePrice10) {
            this.parameters.put("sale_price10", salePrice10);
            return this;
        }

        public PositionRequestBuilder costPrice(long costPrice) {
            this.parameters.put("cost_price", costPrice);
            return this;
        }

        public PositionRequestBuilder exportCost1(@NonNull String exportCost1) {
            this.parameters.put("export_cost1", exportCost1);
            return this;
        }

        public PositionRequestBuilder exportCost2(@NonNull String exportCost2) {
            this.parameters.put("export_cost2", exportCost2);
            return this;
        }

        public PositionRequestBuilder vatPercent(float vatPercent) {
            this.parameters.put("vat_percent", vatPercent);
            return this;
        }

        public PositionRequestBuilder groupId(long groupId) {
            this.parameters.put("group_id", groupId);
            return this;
        }

        public PositionRequestBuilder quantity(float quantity) {
            this.parameters.put("quantity", quantity);
            return this;
        }

        public PositionRequestBuilder archived(boolean archived) {
            this.parameters.put("archived", archived);
            return this;
        }

        public PositionRequestBuilder exportIdentifier(
            @NonNull String exportIdentifier
        ) {
            this.parameters.put("export_identifier", exportIdentifier);
            return this;
        }

        public PositionRequestBuilder stock(
            @NonNull StockActivation stockActivation
        ) {
            this.parameters.put("stock", stockActivation.getValue());
            return this;
        }

        public PositionRequestBuilder stockLimit(int stockLimit) {
            this.parameters.put("stock_limit", stockLimit);
            return this;
        }

        public PositionRequestBuilder stockLimitNotify(
            boolean stockLimitNotify
        ) {
            this.parameters.put("stock_limit_notify", stockLimitNotify);
            return this;
        }

        public PositionRequestBuilder stockLimitNotifyFrequency(
            @NonNull StockLimitNotifyFrequency stockLimitNotifyFrequency
        ) {
            this.parameters.put(
                    "stock_limit_notify_frequency",
                    stockLimitNotifyFrequency.getValue()
                );
            return this;
        }
    }
}
