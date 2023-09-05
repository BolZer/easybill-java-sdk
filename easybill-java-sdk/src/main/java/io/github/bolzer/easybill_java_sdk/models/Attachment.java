package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record Attachment(
    @JsonProperty("id") long id,
    @JsonProperty("size") long size,
    @JsonProperty("customer_id") @Nullable Long customerId,
    @JsonProperty("project_id") @Nullable Long projectId,
    @JsonProperty("document_id") @Nullable Long documentId,
    @JsonProperty("file_name") @NonNull String fileName,
    @JsonProperty("created_at")
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate createdAt
) {}
