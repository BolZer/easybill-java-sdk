package com.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.bolzer.easybill_java_sdk.enums.ServiceDateType;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.LocalDate;

public record ServiceDate(
    @JsonProperty("type") ServiceDateType type,
    @JsonProperty("date") @Nullable LocalDate date,
    @JsonProperty("date_from") @Nullable LocalDate dateFrom,
    @JsonProperty("date_to") @Nullable LocalDate dateTo,
    @JsonProperty("text") @Nullable String text
) {}
