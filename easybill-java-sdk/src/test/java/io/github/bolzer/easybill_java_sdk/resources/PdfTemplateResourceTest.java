package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.enums.DocumentType;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.pdf_templates.PdfTemplateFetchListFixture;
import io.github.bolzer.easybill_java_sdk.fixtures.pdf_templates.PdfTemplateFetchListWithQueryFixture;
import io.github.bolzer.easybill_java_sdk.models.PdfTemplate;
import io.github.bolzer.easybill_java_sdk.requests.PdfTemplateRequest;
import io.github.bolzer.easybill_java_sdk.responses.NonPaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class PdfTemplateResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchPdfTemplates() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(
                new PdfTemplateFetchListFixture(),
                new PdfTemplateFetchListWithQueryFixture()
            )
        );

        final NonPaginatedResponse<PdfTemplate> response = client
            .getPdfTemplateResource()
            .fetchPdfTemplates(
                PdfTemplateRequest
                    .builder()
                    .types(List.of(DocumentType.INVOICE))
                    .build()
            );

        assertThat(response.items().size()).isEqualTo(3);

        final NonPaginatedResponse<PdfTemplate> secondResponse = client
            .getPdfTemplateResource()
            .fetchPdfTemplates();

        assertThat(secondResponse.items().size()).isEqualTo(3);
    }
}
