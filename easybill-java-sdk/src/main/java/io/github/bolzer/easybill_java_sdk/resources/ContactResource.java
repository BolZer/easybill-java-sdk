package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.Contact;
import io.github.bolzer.easybill_java_sdk.requests.ContactRequest;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class ContactResource {

    @NonNull
    public static final String RESOURCE_URL = "/customers";

    @NonNull
    private final HttpClient httpClient;

    public ContactResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<Contact> fetchContacts(
        long customerId,
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/" + customerId + "/contacts",
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Contact fetchContact(long customerId, long contactId)
        throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/" + customerId + "/contacts/" + contactId,
                new TypeReference<>() {}
            );
    }

    public @NonNull Contact createContact(
        long customerId,
        @NonNull ContactRequest contactRequest
    ) throws EasybillRestException {
        return this.httpClient.postJson(
                RESOURCE_URL + "/" + customerId + "/contacts",
                contactRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Contact updateContact(
        @Positive long customerId,
        @Positive long contactId,
        @NonNull ContactRequest contactRequest
    ) throws EasybillRestException {
        return this.httpClient.putJson(
                RESOURCE_URL + "/" + customerId + "/contacts/" + contactId,
                contactRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteContact(
        @Positive long customerId,
        @Positive long contactId
    ) throws EasybillRestException {
        this.httpClient.delete(
                RESOURCE_URL + "/" + customerId + "/contacts/" + contactId
            );
    }
}
