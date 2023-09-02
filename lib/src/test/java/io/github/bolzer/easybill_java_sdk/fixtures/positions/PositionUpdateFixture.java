package io.github.bolzer.easybill_java_sdk.fixtures.positions;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.PositionRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionUpdateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/positions/43";
    }

    public @Nullable Object getPostBody() {
        return PositionRequest
            .builder()
            .number("changed something")
            .description("changed something else")
            .salePrice(2000L)
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                    {
                      "archived": false,
                      "cost_price": null,
                      "description": "changed something else",
                      "document_note": "",
                      "export_cost1": null,
                      "export_cost2": null,
                      "export_identifier": null,
                      "export_identifier_extended": [],
                      "group_id": null,
                      "id": 43,
                      "login_id": 32039,
                      "note": null,
                      "number": "changed something",
                      "price_type": "NETTO",
                      "quantity": null,
                      "sale_price": 2000,
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
                      "vat_percent": 19
                  }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
