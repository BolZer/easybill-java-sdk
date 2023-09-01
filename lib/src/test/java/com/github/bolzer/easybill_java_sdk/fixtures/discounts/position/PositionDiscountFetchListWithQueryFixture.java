package com.github.bolzer.easybill_java_sdk.fixtures.discounts.position;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionDiscountFetchListWithQueryFixture
    implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/discounts/position?limit=1&page=1";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "page": 1,
                    "pages": 1,
                    "limit": 1,
                    "total": 1,
                    "items": [
                        {
                            "customer_id": 6,
                            "discount": 20,
                            "discount_type": "PERCENT",
                            "id": 1,
                            "position_id": 14
                        }
                    ]
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
