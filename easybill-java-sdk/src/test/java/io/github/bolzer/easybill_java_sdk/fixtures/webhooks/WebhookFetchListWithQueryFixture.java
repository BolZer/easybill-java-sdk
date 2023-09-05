package io.github.bolzer.easybill_java_sdk.fixtures.webhooks;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class WebhookFetchListWithQueryFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/webhooks?limit=1&page=2";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                     "page": 2,
                     "pages": 6,
                     "limit": 1,
                     "total": 6,
                     "items": [
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
                     ]
                 }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
