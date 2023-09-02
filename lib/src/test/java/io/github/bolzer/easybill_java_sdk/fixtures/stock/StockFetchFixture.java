package io.github.bolzer.easybill_java_sdk.fixtures.stock;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class StockFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/stocks/9";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                     "created_at": "2023-08-31 14:17:51",
                     "document_id": null,
                     "document_position_id": null,
                     "id": 9,
                     "note": "",
                     "position_id": 2,
                     "stock_count": 100,
                     "stored_at": "2023-08-31 14:17:51",
                     "updated_at": "2023-08-31 14:17:51"
                 }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
