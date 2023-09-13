package io.github.bolzer.easybill_java_sdk.fixtures.attachments;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class AttachmentCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/attachments";
    }

    public @Nullable String getPostBody() {
        return "1\n2\n3\n4\n5";
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                  "created_at": "2023-09-12",
                  "customer_id": null,
                  "document_id": null,
                  "file_name": "attachment.txt",
                  "id": 6604183,
                  "project_id": null,
                  "size": 10
                }
        """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
