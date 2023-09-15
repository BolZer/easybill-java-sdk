package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.PositionGroup;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.PositionGroupRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
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
        return this.httpClient.requestGetJson(
                RESOURCE_URL,
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroup fetchPositionGroup(
        @Positive long positionGroupId
    ) throws EasybillRestException {
        return this.httpClient.requestGetJson(
                RESOURCE_URL + "/" + positionGroupId,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroup createPositionGroup(
        @NonNull PositionGroupRequest positionGroupRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPostJson(
                RESOURCE_URL,
                positionGroupRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroup updatePositionGroup(
        @Positive long positionGroupId,
        @NonNull PositionGroupRequest positionGroupRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPutJson(
                RESOURCE_URL + "/" + positionGroupId,
                positionGroupRequest,
                new TypeReference<>() {}
            );
    }

    public void deletePositionGroup(@Positive long positionGroupId)
        throws EasybillRestException {
        this.httpClient.requestDelete(RESOURCE_URL + "/" + positionGroupId);
    }
}
