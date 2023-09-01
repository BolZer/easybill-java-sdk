package com.github.bolzer.easybill_java_sdk.fixtures.discounts.position;

import com.github.bolzer.easybill_java_sdk.enums.DiscountType;
import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import com.github.bolzer.easybill_java_sdk.requests.PositionDiscountRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionDiscountCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/discounts/position";
    }

    public @Nullable Object getPostBody() {
        return PositionDiscountRequest
            .builder()
            .customerId(1L)
            .positionId(1L)
            .discount(10.5F)
            .discountType(DiscountType.PERCENT)
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "customer_id": 9,
                    "discount": 10.5,
                    "discount_type": "PERCENT",
                    "id": 3,
                    "position_id": 1
                }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
