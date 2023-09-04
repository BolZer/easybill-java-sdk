package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bolzer.easybill_java_sdk.enums.ItemType;
import io.github.bolzer.easybill_java_sdk.enums.PriceType;
import io.github.bolzer.easybill_java_sdk.enums.StockActivation;
import io.github.bolzer.easybill_java_sdk.enums.StockLimitNotifyFrequency;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record Position(
    @JsonProperty("id") long id,

    @JsonProperty("type") @NonNull ItemType type,

    @JsonProperty("number") @NonNull String number,

    @JsonProperty("description") @NonNull String description,

    @JsonProperty("document_note") @NonNull String documentNote,

    @JsonProperty("note") @Nullable String note,

    @JsonProperty("unit") @NonNull String unit,

    @JsonProperty("export_identifier") @Nullable String exportIdentifier,

    @JsonProperty("login_id") long loginId,

    @JsonProperty("price_type") @NonNull PriceType priceType,

    @JsonProperty("vat_percent") float vatPercent,

    @JsonProperty("sale_price") @Nullable Long salePrice,

    @JsonProperty("sale_price2") @Nullable Long salePrice2,

    @JsonProperty("sale_price3") @Nullable Long salePrice3,

    @JsonProperty("sale_price4") @Nullable Long salePrice4,

    @JsonProperty("sale_price5") @Nullable Long salePrice5,

    @JsonProperty("sale_price6") @Nullable Long salePrice6,

    @JsonProperty("sale_price7") @Nullable Long salePrice7,

    @JsonProperty("sale_price8") @Nullable Long salePrice8,

    @JsonProperty("sale_price9") @Nullable Long salePrice9,

    @JsonProperty("sale_price10") @Nullable Long salePrice10,

    @JsonProperty("cost_price") @Nullable Long costPrice,

    @JsonProperty("export_cost1") @Nullable String exportCost1,

    @JsonProperty("export_cost2") @Nullable String exportCost2,

    @JsonProperty("group_id") @Nullable Long groupId,

    @JsonProperty("stock") @Nullable StockActivation stock,

    @JsonProperty("stock_count") @Nullable Integer stockCount,

    @JsonProperty("stock_limit_notify") @Nullable Boolean stockLimitNotify,

    @JsonProperty("stock_limit_notify_frequency")
    @NonNull
    StockLimitNotifyFrequency stockLimitNotifyFrequency,

    @JsonProperty("stock_limit") @Nullable Integer stockLimit,

    @JsonProperty("quantity") @Nullable Float quantity,

    @JsonProperty("archived") boolean archived
) {}
