package com.github.bolzer.easybill_java_sdk.fixtures.serial_number;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class SerialNumberFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/serial-numbers/2";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "created_at": "2023-08-31 07:41:48",
                    "document_id": null,
                    "document_position_id": null,
                    "id": 2,
                    "position_id": 1,
                    "serial_number": "2zNFlrHdDAESfmjLO6xFVnIOWIanqyj4",
                    "used_at": null
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
