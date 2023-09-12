package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.attachments.*;
import io.github.bolzer.easybill_java_sdk.models.Attachment;
import io.github.bolzer.easybill_java_sdk.requests.AttachmentRequest;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public final class AttachmentResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchAttachments() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new AttachmentFetchListWithQueryFixture())
        );

        final PaginatedResponse<Attachment> response = client
            .getAttachmentResource()
            .fetchAttachments(
                GenericListQueryRequest.builder().limit(100).page(1).build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(1);
        assertThat(response.limit()).isEqualTo(100);
        assertThat(response.total()).isEqualTo(1);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchAttachment() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new AttachmentFetchFixture())
        );

        final Attachment response = client
            .getAttachmentResource()
            .fetchAttachment(1L);

        assertThat(response.id()).isEqualTo(1L);
        assertThat(response.size()).isEqualTo(36340);
        assertThat(response.fileName())
            .isEqualTo("istockphoto-690830614-612x612.jpg");
    }

    @Test
    public void testFetchAttachmentContent() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new AttachmentFetchContentFixture())
        );

        List<String> fileData = Arrays.asList("1", "2", "3", "4", "5");

        byte[] data = client.getAttachmentResource().fetchAttachmentContent(1L);

        List<String> dataAsString = Arrays
            .stream(new String(data, StandardCharsets.UTF_8).split("\n"))
            .toList();

        assertThat(dataAsString).isEqualTo(fileData);
    }

    @Test
    public void testCreateAttachment(@TempDir Path tempDir)
        throws IOException, EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new AttachmentCreateFixture())
        );

        List<String> fileData = Arrays.asList("1", "2", "3", "4", "5");
        Path tempFile = Files.createFile(tempDir.resolve("attachment.txt"));
        Files.write(tempFile, fileData);

        Attachment response = client
            .getAttachmentResource()
            .createAttachment(tempFile.toFile());

        assertThat(response.id()).isEqualTo(6604183L);
        assertThat(response.fileName()).isEqualTo("attachment.txt");
        assertThat(response.size()).isEqualTo(10L);
        assertThat(response.createdAt())
            .isEqualTo(LocalDate.parse("2023-09-12"));
    }

    @Test
    public void testDeleteAttachment() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new AttachmentDeleteFixture())
        );

        client.getAttachmentResource().deleteAttachment(1L);
    }

    @Test
    public void testUpdateAttachment() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new AttachmentUpdateFixture())
        );

        final Attachment response = client
            .getAttachmentResource()
            .updateAttachment(
                6604183L,
                AttachmentRequest.builder().projectId(11L).build()
            );

        assertThat(response.id()).isEqualTo(6604183L);
        assertThat(response.projectId()).isEqualTo(11L);
    }
}
