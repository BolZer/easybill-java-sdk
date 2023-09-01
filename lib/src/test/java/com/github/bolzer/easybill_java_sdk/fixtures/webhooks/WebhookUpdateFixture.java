package com.github.bolzer.easybill_java_sdk.fixtures.webhooks;

import com.github.bolzer.easybill_java_sdk.enums.WebhookEvent;
import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import com.github.bolzer.easybill_java_sdk.requests.WebhookRequest;
import java.util.List;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class WebhookUpdateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/webhooks/7";
    }

    public @Nullable Object getPostBody() {
        return WebhookRequest
            .builder()
            .events(List.of(WebhookEvent.DOCUMENT_CREATE))
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                     "content_type": "json",
                     "description": "A test webhook",
                     "events": [
                         "document.create"
                     ],
                     "id": 7,
                     "is_active": true,
                     "last_response": null,
                     "secret": "123456789",
                     "url": "https://bin.com/12345"
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
