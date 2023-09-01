package com.github.bolzer.easybill_java_sdk.fixtures.customer_groups;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import com.github.bolzer.easybill_java_sdk.requests.CustomerGroupRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class CustomerGroupCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/customer-groups";
    }

    public @Nullable Object getPostBody() {
        return CustomerGroupRequest
            .builder()
            .number("00010")
            .description("A test customer group")
            .name("Customer Group")
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "description": "A test customer group",
                    "display_name": "00010 - Customer Group",
                    "id": 12,
                    "name": "Customer Group",
                    "number": "00010"
                }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
