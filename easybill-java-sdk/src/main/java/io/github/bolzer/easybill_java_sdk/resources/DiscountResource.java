package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.PositionDiscount;
import io.github.bolzer.easybill_java_sdk.models.PositionGroupDiscount;
import io.github.bolzer.easybill_java_sdk.requests.DiscountListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.PositionDiscountRequest;
import io.github.bolzer.easybill_java_sdk.requests.PositionGroupDiscountRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class DiscountResource {

    @NonNull
    public static final String RESOURCE_URL = "/discounts";

    @NonNull
    @SuppressFBWarnings
    private final HttpClient httpClient;

    public DiscountResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<PositionDiscount> fetchPositionDiscounts(
        @NonNull DiscountListQueryRequest discountListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/position",
                discountListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionDiscount createPositionDiscount(
        @NonNull PositionDiscountRequest positionDiscountRequest
    ) throws EasybillRestException {
        return this.httpClient.postJson(
                RESOURCE_URL + "/position",
                positionDiscountRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionDiscount fetchPositionDiscount(
        @Positive long positionDiscountId
    ) throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/position/" + positionDiscountId,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionDiscount updatePositionDiscount(
        @Positive long positionDiscountId,
        @NonNull PositionDiscountRequest positionDiscountRequest
    ) throws EasybillRestException {
        return this.httpClient.putJson(
                RESOURCE_URL + "/position/" + positionDiscountId,
                positionDiscountRequest,
                new TypeReference<>() {}
            );
    }

    public void deletePositionDiscount(@Positive long positionDiscountId)
        throws EasybillRestException {
        this.httpClient.delete(
                RESOURCE_URL + "/position/" + positionDiscountId
            );
    }

    public @NonNull PaginatedResponse<PositionGroupDiscount> fetchPositionGroupDiscounts(
        @NonNull DiscountListQueryRequest discountListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/position-group",
                discountListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroupDiscount createPositionGroupDiscount(
        @NonNull PositionGroupDiscountRequest positionGroupDiscountRequest
    ) throws EasybillRestException {
        return this.httpClient.postJson(
                RESOURCE_URL + "/position-group",
                positionGroupDiscountRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroupDiscount fetchPositionGroupDiscount(
        @Positive long positionDiscountId
    ) throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/position-group/" + positionDiscountId,
                new TypeReference<>() {}
            );
    }

    public @NonNull PositionGroupDiscount updatePositionGroupDiscount(
        @Positive long positionDiscountId,
        @NonNull PositionGroupDiscountRequest positionGroupDiscountRequest
    ) throws EasybillRestException {
        return this.httpClient.putJson(
                RESOURCE_URL + "/position-group/" + positionDiscountId,
                positionGroupDiscountRequest,
                new TypeReference<>() {}
            );
    }

    public void deletePositionGroupDiscount(@Positive long positionDiscountId)
        throws EasybillRestException {
        this.httpClient.delete(
                RESOURCE_URL + "/position-group/" + positionDiscountId
            );
    }
}
