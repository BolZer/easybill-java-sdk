package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.SepaPayment;
import io.github.bolzer.easybill_java_sdk.requests.SepaPaymentListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.SepaPaymentRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class SepaPaymentResource {

    @NonNull
    public static final String RESOURCE_URL = "/sepa-payments";

    @NonNull
    private final HttpClient httpClient;

    public SepaPaymentResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<SepaPayment> fetchSepaPayments(
        SepaPaymentListQueryRequest sepaPaymentListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                sepaPaymentListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull SepaPayment fetchSepaPayment(@Positive long sepaPaymentId)
        throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + sepaPaymentId,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull SepaPayment createSepaPayment(
        @NonNull SepaPaymentRequest sepaPaymentRequest
    ) throws EasybillRestException {
        return this.httpClient.doPostRequestAndMarshalJsonInto(
                RESOURCE_URL,
                sepaPaymentRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull SepaPayment updateSepaPayment(
        @Positive long sepaPaymentId,
        @NonNull SepaPaymentRequest sepaPaymentRequest
    ) throws EasybillRestException {
        return this.httpClient.doPutRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + sepaPaymentId,
                sepaPaymentRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteSepaPayment(@Positive long sepaPaymentId)
        throws EasybillRestException {
        this.httpClient.doDeleteRequest(RESOURCE_URL + "/" + sepaPaymentId);
    }
}
