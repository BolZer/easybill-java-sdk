package com.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class TextTemplateRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private TextTemplateRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static TextTemplateRequestBuilder builder() {
        return new TextTemplateRequestBuilder();
    }

    public static class TextTemplateRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public TextTemplateRequest build() {
            return new TextTemplateRequest(this.parameters);
        }

        public TextTemplateRequestBuilder title(@NonNull String title) {
            this.parameters.put("title", title);
            return this;
        }

        public TextTemplateRequestBuilder text(@NonNull String text) {
            this.parameters.put("text", text);
            return this;
        }
    }
}
