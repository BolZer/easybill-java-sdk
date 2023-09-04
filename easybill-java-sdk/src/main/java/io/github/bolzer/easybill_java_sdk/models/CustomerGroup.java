package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record CustomerGroup(
    @JsonProperty("id") long id,
    @JsonProperty("name") @NonNull String name,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("number") @NonNull String number,
    @JsonProperty("display_name") @NonNull String displayName
) {}
