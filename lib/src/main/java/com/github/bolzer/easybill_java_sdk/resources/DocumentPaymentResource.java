package com.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.models.DocumentPayment;
import com.github.bolzer.easybill_java_sdk.requests.DocumentPaymentListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.DocumentPaymentRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class DocumentPaymentResource {

    @NonNull
    public static final String RESOURCE_URL = "/document-payments";

    @NonNull
    private final HttpClient httpClient;

    public DocumentPaymentResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<DocumentPayment> fetchDocumentPayments(
        DocumentPaymentListQueryRequest documentPaymentListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                documentPaymentListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull DocumentPayment fetchDocumentPayment(
        @Positive long documentPaymentId
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + documentPaymentId,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull DocumentPayment createDocumentPayment(
        @NonNull DocumentPaymentRequest documentPaymentRequest
    ) throws EasybillRestException {
        return this.httpClient.doPostRequestAndMarshalJsonInto(
                RESOURCE_URL,
                documentPaymentRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteDocumentPayment(@Positive long documentPaymentId)
        throws EasybillRestException {
        this.httpClient.doDeleteRequest(RESOURCE_URL + "/" + documentPaymentId);
    }
}
