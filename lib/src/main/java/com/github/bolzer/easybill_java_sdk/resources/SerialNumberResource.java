package com.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.models.SerialNumber;
import com.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.SerialNumberRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class SerialNumberResource {

    @NonNull
    public static final String RESOURCE_URL = "/serial-numbers";

    @NonNull
    private final HttpClient httpClient;

    public SerialNumberResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<SerialNumber> fetchSerialNumbers(
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull SerialNumber fetchSerialNumber(
        @Positive long serialNumberId
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + serialNumberId,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull SerialNumber createSerialNumber(
        @NonNull SerialNumberRequest serialNumberRequest
    ) throws EasybillRestException {
        return this.httpClient.doPostRequestAndMarshalJsonInto(
                RESOURCE_URL,
                serialNumberRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteSerialNumber(@Positive long serialNumberId)
        throws EasybillRestException {
        this.httpClient.doDeleteRequest(RESOURCE_URL + "/" + serialNumberId);
    }
}