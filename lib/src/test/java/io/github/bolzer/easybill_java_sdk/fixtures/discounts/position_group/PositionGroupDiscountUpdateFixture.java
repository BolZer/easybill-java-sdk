package io.github.bolzer.easybill_java_sdk.fixtures.discounts.position_group;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.PositionGroupDiscountRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionGroupDiscountUpdateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/discounts/position-group/5";
    }

    public @Nullable Object getPostBody() {
        return PositionGroupDiscountRequest.builder().discount(17.0F).build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "customer_id": 9,
                    "discount": 17.0,
                    "discount_type": "PERCENT",
                    "id": 5,
                    "position_group_id": 2
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
