package com.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.models.PositionDiscount;
import com.github.bolzer.easybill_java_sdk.models.PositionGroupDiscount;
import com.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.PositionDiscountRequest;
import com.github.bolzer.easybill_java_sdk.requests.PositionGroupDiscountRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class DiscountResource {

    @NonNull
    public static final String RESOURCE_URL = "/discounts";

    @NonNull
    private final HttpClient httpClient;

    public DiscountResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<PositionDiscount> fetchPositionDiscounts(
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/position",
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionDiscount createPositionDiscount(
        @NonNull PositionDiscountRequest positionDiscountRequest
    ) throws EasybillRestException {
        return this.httpClient.doPostRequestAndMarshalJsonInto(
                RESOURCE_URL + "/position",
                positionDiscountRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionDiscount fetchPositionDiscount(
        @Positive long positionDiscountId
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/position/" + positionDiscountId,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionDiscount updatePositionDiscount(
        @Positive long positionDiscountId,
        @NonNull PositionDiscountRequest positionDiscountRequest
    ) throws EasybillRestException {
        return this.httpClient.doPutRequestAndMarshalJsonInto(
                RESOURCE_URL + "/position/" + positionDiscountId,
                positionDiscountRequest,
                new TypeReference<>() {}
            );
    }

    public void deletePositionDiscount(@Positive long positionDiscountId)
        throws EasybillRestException {
        this.httpClient.doDeleteRequest(
                RESOURCE_URL + "/position/" + positionDiscountId
            );
    }

    public @NonNull PaginatedResponse<PositionGroupDiscount> fetchPositionGroupDiscounts(
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/position-group",
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroupDiscount createPositionGroupDiscount(
        @NonNull PositionGroupDiscountRequest positionGroupDiscountRequest
    ) throws EasybillRestException {
        return this.httpClient.doPostRequestAndMarshalJsonInto(
                RESOURCE_URL + "/position-group",
                positionGroupDiscountRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroupDiscount fetchPositionGroupDiscount(
        @Positive long positionDiscountId
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/position-group/" + positionDiscountId,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroupDiscount updatePositionGroupDiscount(
        @Positive long positionDiscountId,
        @NonNull PositionGroupDiscountRequest positionGroupDiscountRequest
    ) throws EasybillRestException {
        return this.httpClient.doPutRequestAndMarshalJsonInto(
                RESOURCE_URL + "/position-group/" + positionDiscountId,
                positionGroupDiscountRequest,
                new TypeReference<>() {}
            );
    }

    public void deletePositionGroupDiscount(@Positive long positionDiscountId)
        throws EasybillRestException {
        this.httpClient.doDeleteRequest(
                RESOURCE_URL + "/position-group/" + positionDiscountId
            );
    }
}
