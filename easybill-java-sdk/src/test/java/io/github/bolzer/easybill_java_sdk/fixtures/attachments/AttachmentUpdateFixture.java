package io.github.bolzer.easybill_java_sdk.fixtures.attachments;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.AttachmentRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class AttachmentUpdateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/attachments/6604183";
    }

    public @Nullable Object getPostBody() {
        return AttachmentRequest.builder().projectId(11L).build();
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
                  "project_id": 11,
                  "size": 10
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
