package io.github.bolzer.easybill_java_sdk.fixtures.sepa_payments;

import io.github.bolzer.easybill_java_sdk.enums.SepaLocalInstrumentType;
import io.github.bolzer.easybill_java_sdk.enums.SepaSequenceType;
import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.SepaPaymentRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class SepaPaymentCreateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/sepa-payments";
    }

    public @Nullable Object getPostBody() {
        return SepaPaymentRequest
            .builder()
            .documentId(451784737L)
            .debitorName("Something")
            .debitorIban("DE11111111")
            .mandateId("1234")
            .mandateDateOfSignature(
                LocalDate.parse("2020-01-01", DateTimeFormatter.ISO_DATE)
            )
            .reference("1234")
            .localInstrument(SepaLocalInstrumentType.CORE)
            .sequenceType(SepaSequenceType.FRST)
            .build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                 "amount": 0,
                 "created_at": "2023-08-31 21:59:39",
                 "creditor_bic": null,
                 "creditor_iban": null,
                 "creditor_name": null,
                 "debitor_address_line_1": "",
                 "debitor_address_line_2": "",
                 "debitor_bic": null,
                 "debitor_country": "",
                 "debitor_iban": "DE11111111",
                 "debitor_name": "Something",
                 "document_id": 451784737,
                 "export_at": null,
                 "export_error": null,
                 "id": 9458663,
                 "local_instrument": "CORE",
                 "mandate_date_of_signature": "2020-01-01",
                 "mandate_id": "1234",
                 "reference": "1234",
                 "remittance_information": null,
                 "requested_at": "2023-09-01",
                 "sequence_type": "FRST",
                 "type": "DEBIT",
                 "updated_at": "2023-08-31 21:59:39"
                }
            """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
