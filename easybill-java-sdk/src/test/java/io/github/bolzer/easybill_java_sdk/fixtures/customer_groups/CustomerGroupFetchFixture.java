package io.github.bolzer.easybill_java_sdk.fixtures.customer_groups;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class CustomerGroupFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/customer-groups/2";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                  "description": "",
                  "display_name": "10001 - Agenturen",
                  "id": 2,
                  "name": "Agenturen",
                  "number": "10001"
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
