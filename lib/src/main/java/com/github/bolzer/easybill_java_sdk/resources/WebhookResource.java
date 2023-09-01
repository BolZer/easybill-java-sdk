package com.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.models.Webhook;
import com.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.WebhookRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class WebhookResource {

    @NonNull
    public static final String RESOURCE_URL = "/webhooks";

    @NonNull
    private final HttpClient httpClient;

    public WebhookResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<Webhook> fetchWebhooks(
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Webhook fetchWebhook(@Positive long webhookId)
        throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + webhookId,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull Webhook createWebhook(
        @NonNull WebhookRequest webhookRequest
    ) throws EasybillRestException {
        return this.httpClient.doPostRequestAndMarshalJsonInto(
                RESOURCE_URL,
                webhookRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Webhook updateWebhook(
        @Positive long webhookId,
        @NonNull WebhookRequest webhookRequest
    ) throws EasybillRestException {
        return this.httpClient.doPutRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + webhookId,
                webhookRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteWebhook(@Positive long webhookId)
        throws EasybillRestException {
        this.httpClient.doDeleteRequest(RESOURCE_URL + "/" + webhookId);
    }
}
