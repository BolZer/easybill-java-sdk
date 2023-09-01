package com.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.time.LocalDate;

public record DocumentPayment(
    @JsonProperty("id") long id,
    @JsonProperty("amount") long amount,
    @JsonProperty("document_id") long documentId,
    @JsonProperty("is_overdue_fee") boolean isOverdueFee,
    @JsonProperty("login_id") long loginId,
    @JsonProperty("notice") @NonNull String notice,
    @JsonProperty("provider") @NonNull String provider,
    @JsonProperty("reference") @NonNull String reference,
    @JsonProperty("type") @NonNull String type,
    @JsonProperty("payment_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NonNull
    LocalDate paymentDate
) {}
