package com.github.bolzer.easybill_java_sdk.fixtures.text_templates;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import com.github.bolzer.easybill_java_sdk.requests.TextTemplateRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class TextTemplateCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/text-templates";
    }

    public @Nullable Object getPostBody() {
        return TextTemplateRequest
            .builder()
            .text("This is a fixture for text template")
            .title("Text Template Fixture 2")
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "can_modify": true,
                    "id": 3,
                    "text": "This is a fixture for text template",
                    "title": "Text Template Fixture 2"
                }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
