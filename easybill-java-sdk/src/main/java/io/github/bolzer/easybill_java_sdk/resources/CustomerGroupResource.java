package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.CustomerGroup;
import io.github.bolzer.easybill_java_sdk.requests.CustomerGroupRequest;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class CustomerGroupResource {

    @NonNull
    public static final String RESOURCE_URL = "/customer-groups";

    @NonNull
    private final HttpClient httpClient;

    public CustomerGroupResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<CustomerGroup> fetchCustomerGroups(
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.requestGetJson(
                RESOURCE_URL,
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull CustomerGroup fetchCustomerGroup(
        @Positive long customerGroupId
    ) throws EasybillRestException {
        return this.httpClient.requestGetJson(
                RESOURCE_URL + "/" + customerGroupId,
                new TypeReference<>() {}
            );
    }

    public @NonNull CustomerGroup createCustomerGroup(
        @NonNull CustomerGroupRequest customerGroupRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPostJson(
                RESOURCE_URL,
                customerGroupRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull CustomerGroup updateCustomerGroup(
        @Positive long customerId,
        @NonNull CustomerGroupRequest customerGroupRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPutJson(
                RESOURCE_URL + "/" + customerId,
                customerGroupRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteCustomerGroup(@Positive long customerGroupId)
        throws EasybillRestException {
        this.httpClient.requestDelete(RESOURCE_URL + "/" + customerGroupId);
    }
}
