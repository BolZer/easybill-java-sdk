package io.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentPaymentRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private DocumentPaymentRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static DocumentPaymentRequestBuilder builder() {
        return new DocumentPaymentRequestBuilder();
    }

    public static class DocumentPaymentRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public DocumentPaymentRequest build() {
            return new DocumentPaymentRequest(this.parameters);
        }

        public DocumentPaymentRequestBuilder documentId(
            @Positive long documentId
        ) {
            this.parameters.put("document_id", documentId);
            return this;
        }

        public DocumentPaymentRequestBuilder notice(@NonNull String notice) {
            this.parameters.put("notice", notice);
            return this;
        }

        public DocumentPaymentRequestBuilder reference(
            @NonNull String reference
        ) {
            this.parameters.put("reference", reference);
            return this;
        }

        public DocumentPaymentRequestBuilder type(@NonNull String type) {
            this.parameters.put("type", type);
            return this;
        }

        public DocumentPaymentRequestBuilder provider(
            @NonNull String provider
        ) {
            this.parameters.put("provider", provider);
            return this;
        }

        public DocumentPaymentRequestBuilder amount(int amount) {
            this.parameters.put("amount", amount);
            return this;
        }

        public DocumentPaymentRequestBuilder isOverdueFee(
            boolean isOverdueFee
        ) {
            this.parameters.put("is_overdue_fee", isOverdueFee);
            return this;
        }

        public DocumentPaymentRequestBuilder paymentAt(LocalDate paymentAt) {
            this.parameters.put(
                    "payment_at",
                    paymentAt.format(DateTimeFormatter.ISO_LOCAL_DATE)
                );
            return this;
        }
    }
}
