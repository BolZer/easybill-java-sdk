package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.Customer;
import io.github.bolzer.easybill_java_sdk.requests.CustomerListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.CustomerRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
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
        return this.httpClient.getJson(
                RESOURCE_URL,
                customerListRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Customer fetchCustomer(@Positive long customerId)
        throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/" + customerId,
                new TypeReference<>() {}
            );
    }

    public @NonNull Customer createCustomer(
        @NonNull CustomerRequest customerRequest
    ) throws EasybillRestException {
        return this.httpClient.postJson(
                RESOURCE_URL,
                customerRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Customer updateCustomer(
        @Positive long customerId,
        @NonNull CustomerRequest customerRequest
    ) throws EasybillRestException {
        return this.httpClient.putJson(
                RESOURCE_URL + "/" + customerId,
                customerRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteCustomer(@Positive long customerId)
        throws EasybillRestException {
        this.httpClient.delete(RESOURCE_URL + "/" + customerId);
    }
}
