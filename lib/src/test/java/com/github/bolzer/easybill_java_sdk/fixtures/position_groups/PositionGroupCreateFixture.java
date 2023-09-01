package com.github.bolzer.easybill_java_sdk.fixtures.position_groups;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import com.github.bolzer.easybill_java_sdk.requests.PositionGroupRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionGroupCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/position-groups";
    }

    public @Nullable Object getPostBody() {
        return PositionGroupRequest
            .builder()
            .number("00010")
            .description("A test position group")
            .name("Position Group")
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                   "description": "A test position group",
                   "display_name": "00010 - Position Group",
                   "id": 4,
                   "login_id": 32039,
                   "name": "Position Group",
                   "number": "00010"
                }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
