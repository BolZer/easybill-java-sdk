package com.github.bolzer.easybill_java_sdk.fixtures.position_groups;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionGroupFetchListWithQueryFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/position-groups?limit=1&page=2";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "page": 2,
                    "pages": 3,
                    "limit": 1,
                    "total": 3,
                    "items": [
                        {
                            "description": "PC Games",
                            "display_name": "00018 - PC Games",
                            "id": 2,
                            "login_id": 33666,
                            "name": "PC Games",
                            "number": "00018"
                        }
                    ]
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
