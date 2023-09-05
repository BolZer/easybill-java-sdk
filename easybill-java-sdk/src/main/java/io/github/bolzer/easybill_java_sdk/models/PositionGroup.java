package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.nullness.qual.NonNull;

public record PositionGroup(
    @JsonProperty("id") long id,
    @JsonProperty("login_id") long loginId,
    @JsonProperty("description") @NonNull String description,
    @JsonProperty("display_name") @NonNull String displayName,
    @JsonProperty("name") @NonNull String name,
    @JsonProperty("number") @NonNull String number
) {}
