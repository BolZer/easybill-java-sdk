package com.github.bolzer.easybill_java_sdk.fixtures.discounts.position;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionDiscountFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/discounts/position/1";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "customer_id": 6,
                    "discount": 20,
                    "discount_type": "PERCENT",
                    "id": 1,
                    "position_id": 14
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
