package com.github.bolzer.easybill_java_sdk.fixtures.webhooks;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class WebhookFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/webhooks/2";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "content_type": "json",
                    "description": "Test Webhook \\"2\\" from Fixtures",
                    "events": [
                        "document.create",
                        "document.completed",
                        "document.update",
                        "document.deleted"
                    ],
                    "id": 2,
                    "is_active": false,
                    "last_response": [],
                    "secret": "1234",
                    "url": "https://env.test.local/document_endpoint"
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
