package com.github.bolzer.easybill_java_sdk.fixtures.document_payments;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import com.github.bolzer.easybill_java_sdk.requests.DocumentPaymentRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentPaymentCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/document-payments";
    }

    public @Nullable Object getPostBody() {
        return DocumentPaymentRequest
            .builder()
            .documentId(2L)
            .type("Something")
            .provider("Something")
            .amount(1000)
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                    {
                        "amount": 1000,
                        "document_id": 2,
                        "id": 19,
                        "is_overdue_fee": false,
                        "login_id": 32039,
                        "notice": "",
                        "payment_at": "2023-08-31",
                        "provider": "Something",
                        "reference": "",
                        "type": "Something"
                    }
                """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
