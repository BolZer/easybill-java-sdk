package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.text_templates.*;
import io.github.bolzer.easybill_java_sdk.models.TextTemplate;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.TextTemplateRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class TextTemplateResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchTextTemplates() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new TextTemplateFetchListWithQueryFixture())
        );

        final PaginatedResponse<TextTemplate> response = client
            .getTextTemplateResource()
            .fetchTextTemplates(GenericListQueryRequest.builder().build());

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(1);
        assertThat(response.limit()).isEqualTo(100);
        assertThat(response.total()).isEqualTo(2);
        assertThat(response.items().size()).isEqualTo(2);
    }

    @Test
    public void testFetchTextTemplate() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new TextTemplateFetchFixture())
        );

        final TextTemplate response = client
            .getTextTemplateResource()
            .fetchTextTemplate(2L);

        assertThat(response.id()).isEqualTo(2L);
    }

    @Test
    public void testCreateTextTemplate() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new TextTemplateCreateFixture())
        );

        final TextTemplate response = client
            .getTextTemplateResource()
            .createTextTemplate(
                TextTemplateRequest
                    .builder()
                    .text("This is a fixture for text template")
                    .title("Text Template Fixture 2")
                    .build()
            );

        assertThat(response.text())
            .isEqualTo("This is a fixture for text template");
        assertThat(response.title()).isEqualTo("Text Template Fixture 2");
    }

    @Test
    public void testUpdateTextTemplate() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new TextTemplateUpdateFixture())
        );

        final TextTemplate response = client
            .getTextTemplateResource()
            .updateTextTemplate(
                3L,
                TextTemplateRequest
                    .builder()
                    .title("Text Template Fixture 2000")
                    .build()
            );

        assertThat(response.id()).isEqualTo(3L);
        assertThat(response.title()).isEqualTo("Text Template Fixture 2000");
    }

    @Test
    public void testDeleteTextTemplate() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new TextTemplateDeleteFixture())
        );

        client.getTextTemplateResource().deleteTextTemplate(3L);
    }
}
