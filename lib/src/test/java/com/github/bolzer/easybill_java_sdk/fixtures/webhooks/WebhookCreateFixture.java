package com.github.bolzer.easybill_java_sdk.fixtures.webhooks;

import com.github.bolzer.easybill_java_sdk.enums.WebhookContentType;
import com.github.bolzer.easybill_java_sdk.enums.WebhookEvent;
import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import com.github.bolzer.easybill_java_sdk.requests.WebhookRequest;
import java.util.List;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class WebhookCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/webhooks";
    }

    public @Nullable Object getPostBody() {
        return WebhookRequest
            .builder()
            .contentType(WebhookContentType.JSON)
            .description("A test webhook")
            .secret("123456789")
            .url("https://bin.com/12345")
            .isActive(true)
            .events(
                List.of(
                    WebhookEvent.DOCUMENT_CREATE,
                    WebhookEvent.DOCUMENT_COMPLETED,
                    WebhookEvent.DOCUMENT_UPDATE,
                    WebhookEvent.DOCUMENT_DELETED
                )
            )
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "content_type": "json",
                    "description": "A test webhook",
                    "events": [
                        "document.create",
                        "document.completed",
                        "document.update",
                        "document.deleted"
                    ],
                    "id": 7,
                    "is_active": true,
                    "last_response": null,
                    "secret": "123456789",
                    "url": "https://bin.com/12345"
                }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
