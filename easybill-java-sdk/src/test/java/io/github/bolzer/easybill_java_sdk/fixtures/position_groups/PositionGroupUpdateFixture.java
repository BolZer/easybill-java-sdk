package io.github.bolzer.easybill_java_sdk.fixtures.position_groups;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.PositionGroupRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionGroupUpdateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/position-groups/4";
    }

    public @Nullable Object getPostBody() {
        return PositionGroupRequest
            .builder()
            .number("00011")
            .description("changed position group")
            .name("Changed Position Group")
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                    {
                       "description": "changed position group",
                       "display_name": "00011 - Changed Position Group",
                       "id": 4,
                       "login_id": 32039,
                       "name": "Changed Position Group",
                       "number": "00011"
                    }
                """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
