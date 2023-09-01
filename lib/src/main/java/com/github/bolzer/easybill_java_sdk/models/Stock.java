package com.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.LocalDateTime;

public record Stock(
    @JsonProperty("id") long id,

    @JsonProperty("note") @NonNull String note,

    @JsonProperty("stock_count") long stockCount,

    @JsonProperty("position_id") long positionId,

    @JsonProperty("document_id") @Nullable Long documentId,

    @JsonProperty("document_position_id") @Nullable Long documentPositionId,

    @JsonProperty("stored_at")
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime storedAt,

    @JsonProperty("created_at")
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdAt,

    @JsonProperty("updated_at")
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updatedAt
) {}
