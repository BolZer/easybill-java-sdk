package io.github.bolzer.easybill_java_sdk.fixtures.positions;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionFetchListWithQueryFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/positions?limit=1&page=2";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                                    {
                                        "page": 2,
                                        "pages": 42,
                                        "limit": 1,
                                        "total": 42,
                                        "items": [
                                            {
                                                "archived": true,
                                                "cost_price": null,
                                                "description": "Windows Vista",
                                                "document_note": "",
                                                "export_cost1": null,
                                                "export_cost2": null,
                                                "export_identifier": null,
                                                "export_identifier_extended": [],
                                                "group_id": 1,
                                                "id": 2,
                                                "login_id": 32039,
                                                "note": null,
                                                "number": "99-10002",
                                                "price_type": "NETTO",
                                                "quantity": null,
                                                "sale_price": 4999,
                                                "sale_price10": null,
                                                "sale_price2": null,
                                                "sale_price3": null,
                                                "sale_price4": null,
                                                "sale_price5": null,
                                                "sale_price6": null,
                                                "sale_price7": null,
                                                "sale_price8": null,
                                                "sale_price9": null,
                                                "stock": "NO",
                                                "stock_count": 0,
                                                "stock_limit": 0,
                                                "stock_limit_notify": false,
                                                "stock_limit_notify_frequency": "ALWAYS",
                                                "type": "PRODUCT",
                                                "unit": "",
                                                "vat_percent": 7
                                            }
                                        ]
                                    }
                            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
