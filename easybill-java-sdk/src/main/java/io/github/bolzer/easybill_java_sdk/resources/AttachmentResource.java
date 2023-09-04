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

public final class AttachmentResource {

    @NonNull
    public static final String RESOURCE_URL = "/attachments";

    @NonNull
    private final HttpClient httpClient;

    public AttachmentResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }
}
