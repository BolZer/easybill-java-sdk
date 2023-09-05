package io.github.bolzer.easybill_java_sdk.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.bolzer.easybill_java_sdk.enums.DocumentType;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public final class DocumentListQueryRequestTest {

    @Test
    public void testToMapDoesNotIncludeNullFields() {
        final DocumentListQueryRequest request = DocumentListQueryRequest
            .builder()
            .page(2)
            .limit(50)
            .title(null)
            .build();

        final Map<String, String> map = request.toStringMap();

        assertEquals(2, map.size());
    }

    @Test
    public void testToMapIncludesAllFields() {
        final DocumentListQueryRequest request = DocumentListQueryRequest
            .builder()
            .page(2)
            .limit(50)
            .types(List.of(DocumentType.INVOICE, DocumentType.PROFORMA_INVOICE))
            .documentDate(LocalDate.now())
            .paidAt(LocalDate.now())
            .title("Foobar")
            .number("202320202")
            .refId(10002345L)
            .isDraft(false)
            .status("OKAY")
            .vatCountry("Germany")
            .fulfillmentCountry("Germany")
            .shippingCountry("Germany")
            .isArchive(false)
            .cancelIds(List.of(1234L, 123456L))
            .customerIds(List.of(12345L, 123456L))
            .cancelIds(List.of(123456L, 1234567L))
            .projectIds(List.of(12345L))
            .build();

        final Map<String, String> map = request.toStringMap();

        assertEquals(request.getClass().getDeclaredFields().length, map.size());
    }
}
