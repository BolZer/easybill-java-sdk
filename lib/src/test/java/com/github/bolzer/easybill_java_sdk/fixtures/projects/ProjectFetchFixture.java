package com.github.bolzer.easybill_java_sdk.fixtures.projects;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class ProjectFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/projects/88453";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
             {
                 "budget_amount": 0,
                 "budget_notify_frequency": "ALWAYS",
                 "budget_time": 0,
                 "consumed_amount": 0,
                 "consumed_time": 1,
                 "customer_id": null,
                 "due_at": null,
                 "hourly_rate": 0,
                 "id": 88453,
                 "login_id": 32039,
                 "name": "asdasd",
                 "note": "",
                 "status": "OPEN"
             }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
