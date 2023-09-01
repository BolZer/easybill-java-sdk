package com.github.bolzer.easybill_java_sdk.fixtures.stock;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import com.github.bolzer.easybill_java_sdk.requests.StockRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class StockCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/stocks";
    }

    public @Nullable Object getPostBody() {
        return StockRequest
            .builder()
            .note("00010")
            .stockCount(100L)
            .positionId(2)
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                     "created_at": "2023-08-31 14:17:51",
                     "document_id": null,
                     "document_position_id": null,
                     "id": 9,
                     "note": "00010",
                     "position_id": 2,
                     "stock_count": 100,
                     "stored_at": "2023-08-31 14:17:51",
                     "updated_at": "2023-08-31 14:17:51"
                 }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
