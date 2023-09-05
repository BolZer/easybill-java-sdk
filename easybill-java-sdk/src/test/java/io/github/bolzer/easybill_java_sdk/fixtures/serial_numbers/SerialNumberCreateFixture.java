package io.github.bolzer.easybill_java_sdk.fixtures.serial_numbers;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.SerialNumberRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class SerialNumberCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/serial-numbers";
    }

    public @Nullable Object getPostBody() {
        return SerialNumberRequest
            .builder()
            .serialNumber("00010")
            .positionId(2L)
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "created_at": "2023-08-31 14:30:02",
                    "document_id": null,
                    "document_position_id": null,
                    "id": 30,
                    "position_id": 2,
                    "serial_number": "00010",
                    "used_at": null
                }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
