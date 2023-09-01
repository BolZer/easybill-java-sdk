package com.github.bolzer.easybill_java_sdk.fixtures.customer_groups;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import com.github.bolzer.easybill_java_sdk.requests.CustomerGroupRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class CustomerGroupUpdateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/customer-groups/12";
    }

    public @Nullable Object getPostBody() {
        return CustomerGroupRequest
            .builder()
            .number("00011")
            .description("Changed A test customer group")
            .name("Changed Customer Group")
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "description": "Changed A test customer group",
                    "display_name": "00011 - Changed Customer Group",
                    "id": 12,
                    "name": "Changed Customer Group",
                    "number": "00011"
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
