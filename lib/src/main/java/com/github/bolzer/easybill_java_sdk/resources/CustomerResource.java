package com.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.models.Customer;
import com.github.bolzer.easybill_java_sdk.requests.CustomerListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.CustomerRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class CustomerResource {

    @NonNull
    public static final String RESOURCE_URL = "/customers";

    @NonNull
    private final HttpClient httpClient;

    public CustomerResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<Customer> fetchCustomers(
        CustomerListQueryRequest customerListRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                customerListRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Customer fetchCustomer(@Positive long customerId)
        throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + customerId,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull Customer createCustomer(
        @NonNull CustomerRequest customerRequest
    ) throws EasybillRestException {
        return this.httpClient.doPostRequestAndMarshalJsonInto(
                RESOURCE_URL,
                customerRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Customer updateCustomer(
        @Positive long customerId,
        @NonNull CustomerRequest customerRequest
    ) throws EasybillRestException {
        return this.httpClient.doPutRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + customerId,
                customerRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteCustomer(@Positive long customerId)
        throws EasybillRestException {
        this.httpClient.doDeleteRequest(RESOURCE_URL + "/" + customerId);
    }
}
