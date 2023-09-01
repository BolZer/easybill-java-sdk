package com.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record SepaPayment(
    @JsonProperty("id") long id,
    @JsonProperty("document_id") long documentId,
    @JsonProperty("debitor_name") @NonNull String debitorName,
    @JsonProperty("debitor_iban") @NonNull String debitorIban,
    @JsonProperty("debitor_country") @NonNull String debitorCountry,

    @JsonProperty("debitor_big") @Nullable String debitorBic,
    @JsonProperty("debitor_address_line_1") @NonNull String debitorAddressLine1,
    @JsonProperty("debitor_address_line_2") @NonNull String debitorAddressLine2,
    @JsonProperty("creditor_bic") @Nullable String creditorBic,
    @JsonProperty("creditor_iban") @Nullable String creditorIban,
    @JsonProperty("creditor_name") @Nullable String creditorName,
    @JsonProperty("export_error") @Nullable String exportError,

    @JsonProperty("updated_at")
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updatedAt,

    @JsonProperty("created_at")
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdAt
) {}
