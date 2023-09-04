package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.enums.SepaLocalInstrumentType;
import io.github.bolzer.easybill_java_sdk.enums.SepaSequenceType;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.sepa_payments.*;
import io.github.bolzer.easybill_java_sdk.models.SepaPayment;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.SepaPaymentRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class SepaPaymentResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchSepaPayments() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new SepaPaymentFetchListWithQueryFixture())
        );

        final PaginatedResponse<SepaPayment> response = client
            .getSepaPaymentResource()
            .fetchSepaPayments(
                GenericListQueryRequest.builder().limit(1).page(1).build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(56);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(56);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchSepaPayment() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new SepaPaymentFetchFixture())
        );

        final SepaPayment response = client
            .getSepaPaymentResource()
            .fetchSepaPayment(1194047L);

        assertThat(response.id()).isEqualTo(1194047L);
    }

    @Test
    public void testCreateSepaPayment() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new SepaPaymentCreateFixture())
        );

        final SepaPayment response = client
            .getSepaPaymentResource()
            .createSepaPayment(
                SepaPaymentRequest
                    .builder()
                    .documentId(451784737L)
                    .debitorName("Something")
                    .debitorIban("DE11111111")
                    .mandateId("1234")
                    .mandateDateOfSignature(
                        LocalDate.parse(
                            "2020-01-01",
                            DateTimeFormatter.ISO_DATE
                        )
                    )
                    .reference("1234")
                    .localInstrument(SepaLocalInstrumentType.CORE)
                    .sequenceType(SepaSequenceType.FRST)
                    .build()
            );

        assertThat(response.documentId()).isEqualTo(451784737L);
    }

    @Test
    public void testUpdateSepaPayment() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new SepaPaymentUpdateFixture())
        );

        final SepaPayment response = client
            .getSepaPaymentResource()
            .updateSepaPayment(
                9458663L,
                SepaPaymentRequest
                    .builder()
                    .debitorName("Something Changed")
                    .build()
            );

        assertThat(response.id()).isEqualTo(9458663L);
        assertThat(response.debitorName()).isEqualTo("Something Changed");
    }

    @Test
    public void testDeleteSepaPayment() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new SepaPaymentDeleteFixture())
        );

        client.getSepaPaymentResource().deleteSepaPayment(12L);
    }
}
