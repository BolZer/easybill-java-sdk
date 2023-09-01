package com.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.bolzer.easybill_java_sdk.Client;
import com.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import com.github.bolzer.easybill_java_sdk.enums.WebhookContentType;
import com.github.bolzer.easybill_java_sdk.enums.WebhookEvent;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.fixtures.customer_groups.*;
import com.github.bolzer.easybill_java_sdk.fixtures.webhooks.*;
import com.github.bolzer.easybill_java_sdk.models.Webhook;
import com.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.WebhookRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class WebhookResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchWebhooks() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new WebhookFetchListWithQueryFixture())
        );

        final PaginatedResponse<Webhook> response = client
            .getWebhookResource()
            .fetchWebhooks(
                GenericListQueryRequest.builder().limit(1).page(2).build()
            );

        assertThat(response.page()).isEqualTo(2);
        assertThat(response.pages()).isEqualTo(6);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(6);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchWebhook() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new WebhookFetchFixture())
        );

        final Webhook response = client.getWebhookResource().fetchWebhook(2L);

        assertThat(response.id()).isEqualTo(2L);
    }

    @Test
    public void testCreateWebhook() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new WebhookCreateFixture())
        );

        final Webhook response = client
            .getWebhookResource()
            .createWebhook(
                WebhookRequest
                    .builder()
                    .contentType(WebhookContentType.JSON)
                    .description("A test webhook")
                    .secret("123456789")
                    .url("https://bin.com/12345")
                    .isActive(true)
                    .events(
                        List.of(
                            WebhookEvent.DOCUMENT_CREATE,
                            WebhookEvent.DOCUMENT_COMPLETED,
                            WebhookEvent.DOCUMENT_UPDATE,
                            WebhookEvent.DOCUMENT_DELETED
                        )
                    )
                    .build()
            );

        assertThat(response.contentType()).isEqualTo(WebhookContentType.JSON);
        assertThat(response.description()).isEqualTo("A test webhook");
    }

    @Test
    public void testUpdateWebhook() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new WebhookUpdateFixture())
        );

        final Webhook response = client
            .getWebhookResource()
            .updateWebhook(
                7L,
                WebhookRequest
                    .builder()
                    .events(List.of(WebhookEvent.DOCUMENT_CREATE))
                    .build()
            );

        assertThat(response.id()).isEqualTo(7L);
        assertThat(response.events()).hasSize(1);
    }

    @Test
    public void testDeleteWebhook() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new WebhookDeleteFixture())
        );

        client.getWebhookResource().deleteWebhook(7L);
    }
}
