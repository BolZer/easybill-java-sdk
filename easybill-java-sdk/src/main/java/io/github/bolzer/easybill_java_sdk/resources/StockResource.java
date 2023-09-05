package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.Stock;
import io.github.bolzer.easybill_java_sdk.requests.StockListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.StockRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
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
        StockListQueryRequest stockListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                stockListQueryRequest,
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
