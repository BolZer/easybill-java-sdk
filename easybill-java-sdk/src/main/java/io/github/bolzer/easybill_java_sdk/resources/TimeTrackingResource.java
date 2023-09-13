package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.TimeTracking;
import io.github.bolzer.easybill_java_sdk.requests.TimeTrackingListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.TimeTrackingRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class TimeTrackingResource {

    @NonNull
    public static final String RESOURCE_URL = "/time-trackings";

    @NonNull
    private final HttpClient httpClient;

    public TimeTrackingResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<TimeTracking> fetchTimeTrackings(
        TimeTrackingListQueryRequest timeTrackingListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL,
                timeTrackingListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull TimeTracking fetchTimeTracking(
        @Positive long timeTrackingId
    ) throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/" + timeTrackingId,
                new TypeReference<>() {}
            );
    }

    public @NonNull TimeTracking createTimeTracking(
        @NonNull TimeTrackingRequest timeTrackingRequest
    ) throws EasybillRestException {
        return this.httpClient.postJson(
                RESOURCE_URL,
                timeTrackingRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull TimeTracking updateTimeTracking(
        @Positive long timeTrackingId,
        @NonNull TimeTrackingRequest timeTrackingRequest
    ) throws EasybillRestException {
        return this.httpClient.putJson(
                RESOURCE_URL + "/" + timeTrackingId,
                timeTrackingRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteTimeTracking(@Positive long timeTrackingId)
        throws EasybillRestException {
        this.httpClient.delete(RESOURCE_URL + "/" + timeTrackingId);
    }
}
