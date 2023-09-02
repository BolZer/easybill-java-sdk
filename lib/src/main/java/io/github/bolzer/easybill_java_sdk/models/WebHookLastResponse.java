package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record WebHookLastResponse(
    @JsonProperty("date") @NonNull LocalDateTime date,
    @JsonProperty("code") @NonNull Integer code,
    @JsonProperty("response") @NonNull String response
) {
    // WebHookLastResponse may be a json array instead of a json object
    @JsonCreator
    public static @Nullable WebHookLastResponse fromJsonValue(
        ArrayList<?> json
    ) {
        return null;
    }

    @JsonCreator
    public static @NonNull WebHookLastResponse fromJsonValue(
        LinkedHashMap<@NonNull String, @NonNull String> object
    ) {
        return new WebHookLastResponse(
            LocalDateTime.parse(
                object.getOrDefault("date", ""),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            ),
            Integer.valueOf(object.getOrDefault("code", "0")),
            object.getOrDefault("response", "")
        );
    }
}
