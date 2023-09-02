package io.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.bolzer.easybill_java_sdk.enums.SepaLocalInstrumentType;
import io.github.bolzer.easybill_java_sdk.enums.SepaSequenceType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class SepaPaymentRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private SepaPaymentRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static SepaPaymentRequestBuilder builder() {
        return new SepaPaymentRequestBuilder();
    }

    public static class SepaPaymentRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public SepaPaymentRequest build() {
            return new SepaPaymentRequest(this.parameters);
        }

        public SepaPaymentRequestBuilder documentId(long documentId) {
            this.parameters.put("document_id", documentId);
            return this;
        }

        public SepaPaymentRequestBuilder debitorName(
            @NonNull String debitorName
        ) {
            this.parameters.put("debitor_name", debitorName);
            return this;
        }

        public SepaPaymentRequestBuilder debitorIban(
            @NonNull String debitorIban
        ) {
            this.parameters.put("debitor_iban", debitorIban);
            return this;
        }

        public SepaPaymentRequestBuilder debitorCountry(
            @NonNull String debitorCountry
        ) {
            this.parameters.put("debitor_country", debitorCountry);
            return this;
        }

        public SepaPaymentRequestBuilder debitorBic(
            @NonNull String debitorBic
        ) {
            this.parameters.put("debitor_bic", debitorBic);
            return this;
        }

        public SepaPaymentRequestBuilder mandateId(@NonNull String mandateId) {
            this.parameters.put("mandate_id", mandateId);
            return this;
        }

        public SepaPaymentRequestBuilder mandateDateOfSignature(
            @NonNull LocalDate mandateDateOfSignature
        ) {
            this.parameters.put(
                    "mandate_date_of_signature",
                    mandateDateOfSignature.format(
                        DateTimeFormatter.ISO_LOCAL_DATE
                    )
                );
            return this;
        }

        public SepaPaymentRequestBuilder localInstrument(
            @NonNull SepaLocalInstrumentType sepaLocalInstrumentType
        ) {
            this.parameters.put(
                    "local_instrument",
                    sepaLocalInstrumentType.toString()
                );
            return this;
        }

        public SepaPaymentRequestBuilder sequenceType(
            @NonNull SepaSequenceType sepaSequenceType
        ) {
            this.parameters.put("sequence_type", sepaSequenceType.toString());
            return this;
        }

        public SepaPaymentRequestBuilder reference(@NonNull String reference) {
            this.parameters.put("reference", reference);
            return this;
        }

        public SepaPaymentRequestBuilder amount(long amount) {
            this.parameters.put("amount", amount);
            return this;
        }

        public SepaPaymentRequestBuilder creditorName(
            @NonNull String creditorName
        ) {
            this.parameters.put("creditor_name", creditorName);
            return this;
        }

        public SepaPaymentRequestBuilder creditorIban(
            @NonNull String creditorIban
        ) {
            this.parameters.put("creditor_iban", creditorIban);
            return this;
        }

        public SepaPaymentRequestBuilder creditorBic(
            @NonNull String creditorBic
        ) {
            this.parameters.put("creditor_bic", creditorBic);
            return this;
        }
    }
}
