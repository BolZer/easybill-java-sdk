package com.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.bolzer.easybill_java_sdk.enums.WebhookContentType;
import com.github.bolzer.easybill_java_sdk.enums.WebhookEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class WebhookRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private WebhookRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static WebhookRequestBuilder builder() {
        return new WebhookRequestBuilder();
    }

    public static class WebhookRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public WebhookRequest build() {
            return new WebhookRequest(this.parameters);
        }

        public WebhookRequestBuilder contentType(
            @NonNull WebhookContentType contentType
        ) {
            this.parameters.put("content_type", contentType);
            return this;
        }

        public WebhookRequestBuilder description(@NonNull String description) {
            this.parameters.put("description", description);
            return this;
        }

        public WebhookRequestBuilder secret(@NonNull String secret) {
            this.parameters.put("secret", secret);
            return this;
        }

        public WebhookRequestBuilder url(@NonNull String url) {
            this.parameters.put("url", url);
            return this;
        }

        public WebhookRequestBuilder events(
            @NonNull List<@NonNull WebhookEvent> webhookEvents
        ) {
            this.parameters.put("events", webhookEvents);
            return this;
        }

        public WebhookRequestBuilder isActive(boolean isActive) {
            this.parameters.put("is_active", isActive);
            return this;
        }
    }
}
