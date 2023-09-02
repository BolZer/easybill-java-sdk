package io.github.bolzer.easybill_java_sdk.fixtures.discounts.position_group;

import io.github.bolzer.easybill_java_sdk.enums.DiscountType;
import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.PositionGroupDiscountRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionGroupDiscountCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/discounts/position-group";
    }

    public @Nullable Object getPostBody() {
        return PositionGroupDiscountRequest
            .builder()
            .customerId(9L)
            .discount(10.5F)
            .discountType(DiscountType.PERCENT)
            .positionGroupId(2L)
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "customer_id": 9,
                    "discount": 10.5,
                    "discount_type": "PERCENT",
                    "id": 5,
                    "position_group_id": 2
                }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
