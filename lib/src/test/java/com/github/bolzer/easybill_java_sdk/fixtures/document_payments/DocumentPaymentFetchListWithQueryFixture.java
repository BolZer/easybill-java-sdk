package com.github.bolzer.easybill_java_sdk.fixtures.document_payments;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentPaymentFetchListWithQueryFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/document-payments?limit=1&page=1&document_id=1%2C2%2C3";
    }

    public @Nullable Object getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "page": 1,
                    "pages": 1,
                    "limit": 100,
                    "total": 7,
                    "items": [
                        {
                            "amount": 143276,
                            "document_id": 3,
                            "id": 1,
                            "is_overdue_fee": false,
                            "login_id": 32039,
                            "notice": "",
                            "payment_at": "2023-08-31",
                            "provider": "",
                            "reference": "",
                            "type": "Paypal"
                        },
                        {
                            "amount": 143276,
                            "document_id": 2,
                            "id": 13,
                            "is_overdue_fee": false,
                            "login_id": 32039,
                            "notice": "",
                            "payment_at": "2023-08-31",
                            "provider": "",
                            "reference": "",
                            "type": ""
                        },
                        {
                            "amount": 23,
                            "document_id": 2,
                            "id": 14,
                            "is_overdue_fee": false,
                            "login_id": 32039,
                            "notice": "",
                            "payment_at": "2023-08-31",
                            "provider": "",
                            "reference": "",
                            "type": ""
                        },
                        {
                            "amount": 1000,
                            "document_id": 2,
                            "id": 15,
                            "is_overdue_fee": false,
                            "login_id": 32039,
                            "notice": "",
                            "payment_at": "2023-08-31",
                            "provider": "",
                            "reference": "",
                            "type": ""
                        },
                        {
                            "amount": 1000,
                            "document_id": 2,
                            "id": 16,
                            "is_overdue_fee": false,
                            "login_id": 32039,
                            "notice": "",
                            "payment_at": "2023-08-31",
                            "provider": "",
                            "reference": "",
                            "type": "Something"
                        },
                        {
                            "amount": 1000,
                            "document_id": 2,
                            "id": 17,
                            "is_overdue_fee": false,
                            "login_id": 32039,
                            "notice": "",
                            "payment_at": "2023-08-31",
                            "provider": "Something",
                            "reference": "",
                            "type": "Something"
                        },
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
                    ]
                }
                    """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
