package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record TimeTracking(
    @JsonProperty("id") long id,
    @JsonProperty("cleared_at")
    @Nullable
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime clearedAt,
    @JsonProperty("created_at")
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdAt,
    @JsonProperty("date")
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date,
    @JsonProperty("date_from_at")
    @Nullable
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateFromAt,
    @JsonProperty("date_thru_at")
    @Nullable
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateThruAt,
    @JsonProperty("description") @NonNull String description,
    @JsonProperty("hourly_rate") long hourlyRate,
    @JsonProperty("note") @NonNull String note,
    @JsonProperty("number") @NonNull String number,
    @JsonProperty("login_id") long loginId,
    @JsonProperty("position_id") @Nullable Long positionId,
    @JsonProperty("project_id") @Nullable Long projectId,
    @JsonProperty("timer_value") long timeValue
) {}
