package com.github.bolzer.easybill_java_sdk.fixtures.discounts.position_group;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionGroupDiscountFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/discounts/position-group/2";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "customer_id": 3,
                    "discount": 500,
                    "discount_type": "QUANTITY",
                    "id": 2,
                    "position_group_id": 2
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
