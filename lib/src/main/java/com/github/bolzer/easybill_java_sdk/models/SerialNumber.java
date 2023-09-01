package com.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.LocalDateTime;

public record SerialNumber(
    @JsonProperty("id") long id,
    @JsonProperty("position_id") long positionId,
    @JsonProperty("serial_number") @NonNull String serialNumber,
    @JsonProperty("document_id") @Nullable Long documentId,
    @JsonProperty("document_position_id") @Nullable Long documentPositionId,
    @JsonProperty("used_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NonNull
    LocalDateTime usedAt,
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NonNull
    LocalDateTime createdAt
) {}
