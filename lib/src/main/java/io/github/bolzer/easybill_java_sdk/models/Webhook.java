package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bolzer.easybill_java_sdk.enums.WebhookContentType;
import io.github.bolzer.easybill_java_sdk.enums.WebhookEvent;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record Webhook(
    @JsonProperty("content_type") @NonNull WebhookContentType contentType,

    @JsonProperty("description") @NonNull String description,

    @JsonProperty("events") @NonNull List<@NonNull WebhookEvent> events,

    @JsonProperty("id") long id,

    @JsonProperty("is_active") boolean isActive,

    @JsonProperty("last_response") @Nullable WebHookLastResponse lastResponse,

    @JsonProperty("secret") @NonNull String secret,

    @JsonProperty("url") @NonNull String url
) {
    public Webhook(
        @JsonProperty("content_type") @NonNull WebhookContentType contentType,
        @JsonProperty("description") @NonNull String description,
        @JsonProperty("events") @NonNull List<@NonNull WebhookEvent> events,
        @JsonProperty("id") long id,
        @JsonProperty("is_active") boolean isActive,
        @JsonProperty(
            "last_response"
        ) @Nullable WebHookLastResponse lastResponse,
        @JsonProperty("secret") @NonNull String secret,
        @JsonProperty("url") @NonNull String url
    ) {
        this.contentType = contentType;
        this.description = description;
        this.events = Collections.unmodifiableList(events);
        this.id = id;
        this.isActive = isActive;
        this.lastResponse = lastResponse;
        this.secret = secret;
        this.url = url;
    }
}
