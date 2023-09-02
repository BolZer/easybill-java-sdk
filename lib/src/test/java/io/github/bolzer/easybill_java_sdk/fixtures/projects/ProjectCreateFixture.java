package io.github.bolzer.easybill_java_sdk.fixtures.projects;

import io.github.bolzer.easybill_java_sdk.enums.ProjectStatus;
import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.ProjectRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class ProjectCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/projects";
    }

    public @Nullable Object getPostBody() {
        return ProjectRequest
            .builder()
            .name("Test")
            .note("Test Note")
            .status(ProjectStatus.CANCEL)
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                  "budget_amount": 0,
                  "budget_notify_frequency": "ALWAYS",
                  "budget_time": 0,
                  "consumed_amount": 0,
                  "consumed_time": 0,
                  "customer_id": null,
                  "due_at": null,
                  "hourly_rate": 0,
                  "id": 431568,
                  "login_id": 192112,
                  "name": "Test",
                  "note": "Test Note",
                  "status": "CANCEL"
                }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
