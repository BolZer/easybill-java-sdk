package io.github.bolzer.easybill_java_sdk.fixtures.discounts.position;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.PositionDiscountRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionDiscountUpdateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/discounts/position/3";
    }

    public @Nullable Object getPostBody() {
        return PositionDiscountRequest.builder().discount(12.7F).build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "customer_id": 9,
                    "discount": 12.7,
                    "discount_type": "PERCENT",
                    "id": 3,
                    "position_id": 1
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
