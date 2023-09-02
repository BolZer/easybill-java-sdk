package io.github.bolzer.easybill_java_sdk.fixtures.text_templates;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class TextTemplateFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/text-templates/2";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "can_modify": true,
                    "id": 2,
                    "text": "This is a fixture for text template",
                    "title": "Text Template Fixture 2"
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
