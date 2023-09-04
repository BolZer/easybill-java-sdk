package io.github.bolzer.easybill_java_sdk.fixtures.time_tracking;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.TimeTrackingRequest;
import java.time.LocalDateTime;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class TimeTrackingCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/time-trackings";
    }

    public @Nullable Object getPostBody() {
        return TimeTrackingRequest
            .builder()
            .description("Test")
            .positionId(1L)
            .clearedAt(LocalDateTime.parse("2020-01-01T01:01:01"))
            .note("Test Note")
            .number("Test")
            .dateFromAt(LocalDateTime.parse("2020-03-03T23:23:23"))
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                     "cleared_at": "2020-01-01 01:01:01",
                     "created_at": "2023-09-01 08:36:12",
                     "date": "2023-09-01",
                     "date_from_at": "2021-03-03 23:23:23",
                     "date_thru_at": null,
                     "description": "Test",
                     "hourly_rate": 0,
                     "id": 55,
                     "login_id": 32039,
                     "note": "Test Note",
                     "number": "Test",
                     "position_id": 1,
                     "project_id": null,
                     "timer_value": 0
                 }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
