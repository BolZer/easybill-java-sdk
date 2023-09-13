package io.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class AttachmentRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private AttachmentRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static AttachmentRequestBuilder builder() {
        return new AttachmentRequestBuilder();
    }

    public static class AttachmentRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public AttachmentRequest build() {
            return new AttachmentRequest(this.parameters);
        }

        public AttachmentRequestBuilder customerId(@NonNull Long customerId) {
            this.parameters.put("customer_id", customerId);
            return this;
        }

        public AttachmentRequestBuilder documentId(@NonNull Long documentId) {
            this.parameters.put("document_id", documentId);
            return this;
        }

        public AttachmentRequestBuilder projectId(@NonNull Long projectId) {
            this.parameters.put("project_id", projectId);
            return this;
        }
    }
}
