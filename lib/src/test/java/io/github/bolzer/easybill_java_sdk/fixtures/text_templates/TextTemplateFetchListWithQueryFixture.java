package io.github.bolzer.easybill_java_sdk.fixtures.text_templates;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class TextTemplateFetchListWithQueryFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/text-templates?limit=100&page=1";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                    {
                        "page": 1,
                        "pages": 1,
                        "limit": 100,
                        "total": 2,
                        "items": [
                            {
                                "can_modify": true,
                                "id": 1,
                                "text": "This is a fixture for text template",
                                "title": "Text Template Fixture 1"
                            },
                            {
                                "can_modify": true,
                                "id": 2,
                                "text": "This is a fixture for text template",
                                "title": "Text Template Fixture 2"
                            }
                        ]
                    }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
