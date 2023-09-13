package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.enums.DocumentSendType;
import io.github.bolzer.easybill_java_sdk.enums.DocumentType;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.documents.*;
import io.github.bolzer.easybill_java_sdk.models.Document;
import io.github.bolzer.easybill_java_sdk.requests.DocumentListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.DocumentRequest;
import io.github.bolzer.easybill_java_sdk.requests.DocumentSendRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class DocumentResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchDocuments() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentFetchListFixture())
        );

        final PaginatedResponse<Document> response = client
            .getDocumentsResource()
            .fetchDocuments(
                DocumentListQueryRequest.builder().limit(2).build()
            );

        assertEquals(1, response.page());
        assertEquals(1179, response.pages());
        assertEquals(2, response.limit());
        assertEquals(2357, response.total());
        assertEquals(2, response.items().size());
    }

    @Test
    public void testFetchDocumentsWithQuery() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentFetchListWithQuery())
        );

        final PaginatedResponse<Document> response = client
            .getDocumentsResource()
            .fetchDocuments(
                DocumentListQueryRequest
                    .builder()
                    .limit(5)
                    .page(2)
                    .type(DocumentType.PDF)
                    .build()
            );

        assertEquals(2, response.page());
        assertEquals(3, response.pages());
        assertEquals(5, response.limit());
        assertEquals(11, response.total());
        assertEquals(5, response.items().size());
    }

    @Test
    public void testFetchDocument() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(
                new DocumentInvoiceFetchFixture(),
                new DocumentReminderFetchFixture(),
                new DocumentDunningFetchFixture()
            )
        );

        var response = client.getDocumentsResource().fetchDocument(293594830L);
        assertThat(response.id()).isEqualTo(293594830L);

        response = client.getDocumentsResource().fetchDocument(2577328538L);
        assertThat(response.id()).isEqualTo(2577328538L);

        response = client.getDocumentsResource().fetchDocument(2577329243L);
        assertThat(response.id()).isEqualTo(2577329243L);
    }

    @Test
    public void testCreateDocument() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentCreateFixture())
        );

        final Document response = client
            .getDocumentsResource()
            .createDocument(
                DocumentRequest.builder().title("something").build()
            );

        assertThat(response.title()).isEqualTo("something");
    }

    @Test
    public void testUpdateDocument() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentUpdateFixture())
        );

        final Document response = client
            .getDocumentsResource()
            .updateDocument(
                2558029173L,
                DocumentRequest.builder().title("something_else").build()
            );

        assertThat(response.title()).isEqualTo("something_else");
    }

    @Test
    public void testDeleteDocument() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentDeleteFixture())
        );

        client.getDocumentsResource().deleteDocument(2558029173L);
    }

    @Test
    public void testCancelDocument() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentCancelFixture())
        );

        client.getDocumentsResource().cancelDocument(2558029173L);
    }

    @Test
    public void testFinalizeDocument() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentFinalizeFixture())
        );

        Document document = client
            .getDocumentsResource()
            .finalizeDocument(
                139L,
                DocumentRequest
                    .builder()
                    .title("finalized")
                    .customerId(3L)
                    .build()
            );

        assertThat(document.title()).isEqualTo("finalized");
        assertThat(document.customerId()).isEqualTo(3L);
    }

    @Test
    public void testCopyDocument() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentCopyFixture())
        );

        Document document = client
            .getDocumentsResource()
            .copyDocument(
                139L,
                DocumentType.REMINDER,
                DocumentRequest
                    .builder()
                    .number("Reminder for your Payment")
                    .build()
            );

        assertThat(document.number()).isEqualTo("Reminder for your Payment");
        assertThat(document.type()).isEqualTo(DocumentType.REMINDER);
    }

    @Test
    public void testSendDocument() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentEmailSendFixture())
        );

        client
            .getDocumentsResource()
            .sendDocument(
                2558029173L,
                DocumentSendType.EMAIL,
                DocumentSendRequest
                    .builder()
                    .subject("Test Message")
                    .message("Test Message Content")
                    .from("dev@easybill.de")
                    .to("random@test.de")
                    .sendBySelf(false)
                    .build()
            );
    }

    @Test
    public void testDownloadAsJpg() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentDownloadJpgFixture())
        );

        byte[] result = client
            .getDocumentsResource()
            .downloadDocumentAsJpg(2558029173L);

        assertThat(result).isEqualTo("Jpg".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    public void testDownloadAsPdf() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new DocumentDownloadPdfFixture())
        );

        byte[] result = client
            .getDocumentsResource()
            .downloadDocumentAsPdf(2558029173L);

        assertThat(result).isEqualTo("Pdf".getBytes(StandardCharsets.UTF_8));
    }
}
