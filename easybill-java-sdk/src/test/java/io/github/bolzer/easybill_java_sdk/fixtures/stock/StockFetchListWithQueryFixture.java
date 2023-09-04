package io.github.bolzer.easybill_java_sdk.fixtures.stock;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class StockFetchListWithQueryFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/stocks?limit=1&page=1";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "page": 1,
                    "pages": 9,
                    "limit": 1,
                    "total": 9,
                    "items": [
                        {
                            "created_at": "2023-08-31 07:41:48",
                            "document_id": null,
                            "document_position_id": null,
                            "id": 1,
                            "note": "",
                            "position_id": 4,
                            "stock_count": 5,
                            "stored_at": "2023-08-31 07:41:48",
                            "updated_at": "2023-08-31 07:41:48"
                        }
                    ]
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
