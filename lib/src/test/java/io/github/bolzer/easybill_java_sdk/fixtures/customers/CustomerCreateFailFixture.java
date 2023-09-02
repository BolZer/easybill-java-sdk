package io.github.bolzer.easybill_java_sdk.fixtures.customers;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.CustomerRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class CustomerCreateFailFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/customers";
    }

    public @Nullable Object getPostBody() {
        return CustomerRequest.builder().build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                    {
                        "code": 20000,
                        "message": "Bitte füllen Sie alle Felder aus.",
                        "arguments": [
                            "last_name",
                            "company_name"
                        ]
                    }
            """;

        return new MockResponse().setResponseCode(400).setBody(jsonResponse);
    }
}
