package io.github.bolzer.easybill_java_sdk.fixtures.text_templates;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.TextTemplateRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class TextTemplateUpdateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/text-templates/3";
    }

    public @Nullable Object getPostBody() {
        return TextTemplateRequest
            .builder()
            .title("Text Template Fixture 2000")
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                 {
                    "can_modify": true,
                    "id": 3,
                    "text": "This is a fixture for text template",
                    "title": "Text Template Fixture 2000"
                }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
