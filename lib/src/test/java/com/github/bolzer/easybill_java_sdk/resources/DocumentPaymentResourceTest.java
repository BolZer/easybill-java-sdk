package com.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.bolzer.easybill_java_sdk.Client;
import com.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.fixtures.customer_groups.*;
import com.github.bolzer.easybill_java_sdk.fixtures.document_payments.*;
import com.github.bolzer.easybill_java_sdk.models.DocumentPayment;
import com.github.bolzer.easybill_java_sdk.requests.DocumentPaymentListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.DocumentPaymentRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class DocumentPaymentResourceTest
    extends EasybillRestClientTestcase {

    @Test
    public void testFetchDocumentPayments() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentPaymentFetchListWithQueryFixture())
        );

        final PaginatedResponse<DocumentPayment> response = client
            .getDocumentPaymentResource()
            .fetchDocumentPayments(
                DocumentPaymentListQueryRequest
                    .builder()
                    .limit(1)
                    .page(1)
                    .documentIds(List.of(1L, 2L, 3L))
                    .build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(1);
        assertThat(response.limit()).isEqualTo(100);
        assertThat(response.total()).isEqualTo(7);
        assertThat(response.items().size()).isEqualTo(7);
    }

    @Test
    public void testFetchDocumentPayment() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentPaymentFetchFixture())
        );

        final DocumentPayment response = client
            .getDocumentPaymentResource()
            .fetchDocumentPayment(18L);

        assertThat(response.id()).isEqualTo(18L);
    }

    @Test
    public void testCreateDocumentPayment() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentPaymentCreateFixture())
        );

        final DocumentPayment response = client
            .getDocumentPaymentResource()
            .createDocumentPayment(
                DocumentPaymentRequest
                    .builder()
                    .documentId(2L)
                    .type("Something")
                    .provider("Something")
                    .amount(1000)
                    .build()
            );

        assertThat(response.documentId()).isEqualTo(2L);
        assertThat(response.amount()).isEqualTo(1000);
    }

    @Test
    public void testDeleteDocumentPayment() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentPaymentDeleteFixture())
        );

        client.getDocumentPaymentResource().deleteDocumentPayment(18L);
    }
}
