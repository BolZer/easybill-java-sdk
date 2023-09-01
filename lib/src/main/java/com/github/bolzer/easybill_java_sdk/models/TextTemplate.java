package com.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.nullness.qual.NonNull;

public record TextTemplate(
    @JsonProperty("id") long id,
    @JsonProperty("can_modify") boolean canModify,
    @JsonProperty("text") @NonNull String text,
    @JsonProperty("title") @NonNull String title
) {}
