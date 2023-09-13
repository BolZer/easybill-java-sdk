package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.Webhook;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.WebhookRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class WebhookResource {

    @NonNull
    public static final String RESOURCE_URL = "/webhooks";

    @NonNull
    @SuppressFBWarnings
    private final HttpClient httpClient;

    public WebhookResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<Webhook> fetchWebhooks(
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL,
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Webhook fetchWebhook(@Positive long webhookId)
        throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/" + webhookId,
                new TypeReference<>() {}
            );
    }

    public @NonNull Webhook createWebhook(
        @NonNull WebhookRequest webhookRequest
    ) throws EasybillRestException {
        return this.httpClient.postJson(
                RESOURCE_URL,
                webhookRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Webhook updateWebhook(
        @Positive long webhookId,
        @NonNull WebhookRequest webhookRequest
    ) throws EasybillRestException {
        return this.httpClient.putJson(
                RESOURCE_URL + "/" + webhookId,
                webhookRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteWebhook(@Positive long webhookId)
        throws EasybillRestException {
        this.httpClient.delete(RESOURCE_URL + "/" + webhookId);
    }
}
