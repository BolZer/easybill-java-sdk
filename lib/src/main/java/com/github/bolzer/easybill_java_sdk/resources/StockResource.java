package com.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.models.Stock;
import com.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.StockRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class StockResource {

    @NonNull
    public static final String RESOURCE_URL = "/stocks";

    @NonNull
    private final HttpClient httpClient;

    public StockResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<Stock> fetchStocks(
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Stock fetchStock(@Positive long stockId)
        throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + stockId,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull Stock createStock(@NonNull StockRequest stockRequest)
        throws EasybillRestException {
        return this.httpClient.doPostRequestAndMarshalJsonInto(
                RESOURCE_URL,
                stockRequest,
                new TypeReference<>() {}
            );
    }
}
