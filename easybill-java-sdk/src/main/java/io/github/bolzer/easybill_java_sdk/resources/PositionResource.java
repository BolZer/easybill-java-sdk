package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.Position;
import io.github.bolzer.easybill_java_sdk.requests.PositionListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.PositionRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class PositionResource {

    @NonNull
    public static final String RESOURCE_URL = "/positions";

    @NonNull
    @SuppressFBWarnings
    private final HttpClient httpClient;

    public PositionResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<Position> fetchPositions(
        PositionListQueryRequest positionListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL,
                positionListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Position fetchPosition(@Positive long positionId)
        throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/" + positionId,
                new TypeReference<>() {}
            );
    }

    public @NonNull Position createPosition(
        @NonNull PositionRequest positionRequest
    ) throws EasybillRestException {
        return this.httpClient.postJson(
                RESOURCE_URL,
                positionRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Position updatePosition(
        @Positive long positionId,
        @NonNull PositionRequest positionRequest
    ) throws EasybillRestException {
        return this.httpClient.putJson(
                RESOURCE_URL + "/" + positionId,
                positionRequest,
                new TypeReference<>() {}
            );
    }

    public void deletePosition(@Positive long positionId)
        throws EasybillRestException {
        this.httpClient.delete(RESOURCE_URL + "/" + positionId);
    }
}
