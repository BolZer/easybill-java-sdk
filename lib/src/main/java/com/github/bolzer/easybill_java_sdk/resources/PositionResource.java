package com.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.models.Position;
import com.github.bolzer.easybill_java_sdk.requests.PositionListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.PositionRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class PositionResource {

    @NonNull
    public static final String RESOURCE_URL = "/positions";

    @NonNull
    private final HttpClient httpClient;

    public PositionResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<Position> fetchPositions(
        PositionListQueryRequest positionListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                positionListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Position fetchPosition(@Positive long positionId)
        throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + positionId,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull Position createPosition(
        @NonNull PositionRequest positionRequest
    ) throws EasybillRestException {
        return this.httpClient.doPostRequestAndMarshalJsonInto(
                RESOURCE_URL,
                positionRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Position updatePosition(
        @Positive long positionId,
        @NonNull PositionRequest positionRequest
    ) throws EasybillRestException {
        return this.httpClient.doPutRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + positionId,
                positionRequest,
                new TypeReference<>() {}
            );
    }

    public void deletePosition(@Positive long positionId)
        throws EasybillRestException {
        this.httpClient.doDeleteRequest(RESOURCE_URL + "/" + positionId);
    }
}
