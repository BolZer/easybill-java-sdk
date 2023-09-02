package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bolzer.easybill_java_sdk.enums.ServiceDateType;
import java.time.LocalDate;
import org.checkerframework.checker.nullness.qual.Nullable;

public record ServiceDate(
    @JsonProperty("type") ServiceDateType type,
    @JsonProperty("date") @Nullable LocalDate date,
    @JsonProperty("date_from") @Nullable LocalDate dateFrom,
    @JsonProperty("date_to") @Nullable LocalDate dateTo,
    @JsonProperty("text") @Nullable String text
) {}
