package com.github.bolzer.easybill_java_sdk.fixtures.document_payments;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentPaymentFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/document-payments/18";
    }

    public @Nullable Object getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "amount": 1000,
                    "document_id": 2,
                    "id": 18,
                    "is_overdue_fee": false,
                    "login_id": 32039,
                    "notice": "",
                    "payment_at": "2023-08-31",
                    "provider": "Something",
                    "reference": "",
                    "type": "Something"
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
