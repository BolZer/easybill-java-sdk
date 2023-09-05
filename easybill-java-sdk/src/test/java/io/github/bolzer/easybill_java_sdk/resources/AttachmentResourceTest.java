package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.attachments.AttachmentFetchFixture;
import io.github.bolzer.easybill_java_sdk.fixtures.attachments.AttachmentFetchListWithQueryFixture;
import io.github.bolzer.easybill_java_sdk.models.Attachment;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

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
}
