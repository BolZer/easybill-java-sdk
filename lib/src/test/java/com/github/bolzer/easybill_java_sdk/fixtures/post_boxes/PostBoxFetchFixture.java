package com.github.bolzer.easybill_java_sdk.fixtures.post_boxes;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PostBoxFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/post-boxes/1";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "cc": null,
                    "create_at": "2023-08-31 07:41:55",
                    "date": "2018-10-11",
                    "document_file_type": "default",
                    "document_id": 135,
                    "from": "vagrant@easybill.de",
                    "id": 1,
                    "login_id": 32039,
                    "message": "Postbox Beispieltext",
                    "processed_at": null,
                    "send_by_self": false,
                    "send_with_attachment": true,
                    "status": "OK",
                    "status_msg": null,
                    "subject": "Beispiel PostBox",
                    "to": "dev@easybill.de",
                    "type": "EMAIL"
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
