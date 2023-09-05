package io.github.bolzer.easybill_java_sdk.fixtures.attachments;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class AttachmentFetchListWithQueryFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/attachments?limit=100&page=1";
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
                    "total": 1,
                    "items": [
                        {
                            "created_at": "2023-09-05",
                            "customer_id": null,
                            "document_id": null,
                            "file_name": "istockphoto-690830614-612x612.jpg",
                            "id": 1,
                            "project_id": null,
                            "size": 36340
                        }
                    ]
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
