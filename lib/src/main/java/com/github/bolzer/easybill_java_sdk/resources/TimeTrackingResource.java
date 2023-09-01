package com.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.models.TimeTracking;
import com.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.TimeTrackingRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
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
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull TimeTracking fetchTimeTracking(
        @Positive long timeTrackingId
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + timeTrackingId,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull TimeTracking createTimeTracking(
        @NonNull TimeTrackingRequest timeTrackingRequest
    ) throws EasybillRestException {
        return this.httpClient.doPostRequestAndMarshalJsonInto(
                RESOURCE_URL,
                timeTrackingRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull TimeTracking updateTimeTracking(
        @Positive long timeTrackingId,
        @NonNull TimeTrackingRequest timeTrackingRequest
    ) throws EasybillRestException {
        return this.httpClient.doPutRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + timeTrackingId,
                timeTrackingRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteTimeTracking(@Positive long timeTrackingId)
        throws EasybillRestException {
        this.httpClient.doDeleteRequest(RESOURCE_URL + "/" + timeTrackingId);
    }
}
