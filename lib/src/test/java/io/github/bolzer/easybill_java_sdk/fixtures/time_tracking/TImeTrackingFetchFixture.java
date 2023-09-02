package io.github.bolzer.easybill_java_sdk.fixtures.time_tracking;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class TImeTrackingFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/time-trackings/36";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "cleared_at": "2023-08-30 10:34:24",
                    "created_at": "2023-07-21 10:14:53",
                    "date": "2023-07-21",
                    "date_from_at": "2023-08-21 08:00:00",
                    "date_thru_at": "2023-08-21 17:00:00",
                    "description": "Arbeiten von Morgens bis Abends.",
                    "hourly_rate": 4000,
                    "id": 36,
                    "login_id": 32039,
                    "note": "",
                    "number": "1337-11",
                    "position_id": null,
                    "project_id": 1,
                    "timer_value": 480
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
