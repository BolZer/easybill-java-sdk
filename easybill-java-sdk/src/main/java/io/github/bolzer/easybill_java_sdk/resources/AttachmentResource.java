package io.github.bolzer.easybill_java_sdk.resources;

import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
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
