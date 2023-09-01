package com.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.models.PositionGroup;
import com.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.PositionGroupRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class PositionGroupResource {

    @NonNull
    public static final String RESOURCE_URL = "/position-groups";

    @NonNull
    private final HttpClient httpClient;

    public PositionGroupResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<PositionGroup> fetchPositionGroups(
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroup fetchPositionGroup(
        @Positive long positionGroupId
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + positionGroupId,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroup createPositionGroup(
        @NonNull PositionGroupRequest positionGroupRequest
    ) throws EasybillRestException {
        return this.httpClient.doPostRequestAndMarshalJsonInto(
                RESOURCE_URL,
                positionGroupRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroup updatePositionGroup(
        @Positive long positionGroupId,
        @NonNull PositionGroupRequest positionGroupRequest
    ) throws EasybillRestException {
        return this.httpClient.doPutRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + positionGroupId,
                positionGroupRequest,
                new TypeReference<>() {}
            );
    }

    public void deletePositionGroup(@Positive long positionGroupId)
        throws EasybillRestException {
        this.httpClient.doDeleteRequest(RESOURCE_URL + "/" + positionGroupId);
    }
}