package io.github.bolzer.easybill_java_sdk.fixtures.sepa_payments;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class SepaPaymentFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/sepa-payments/1194047";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                 {
                   "amount": 215069,
                   "created_at": "2019-05-16 08:40:03",
                   "creditor_bic": "DEUTDEDBDUE",
                   "creditor_iban": "CH4431999123000889012",
                   "creditor_name": "easybill GmbH",
                   "debitor_address_line_1": "",
                   "debitor_address_line_2": "",
                   "debitor_bic": "DEUTDEDBDUE",
                   "debitor_country": "",
                   "debitor_iban": "DE58300700240509944500",
                   "debitor_name": "easybill GmbH",
                   "document_id": 451784737,
                   "export_at": "2023-03-08 11:48:15",
                   "export_error": null,
                   "id": 1194047,
                   "local_instrument": "B2B",
                   "mandate_date_of_signature": "1899-12-31",
                   "mandate_id": "31337",
                   "reference": "2000003391",
                   "remittance_information": "Glaeubiger-ID: DE98ZZZ09999999999\\nMandatsreferenz: 31337 vom 31.12.1899\\nRechnung Nr. 2000003391 vom 16.05.2019\\nKunde Nr. 31337\\n",
                   "requested_at": "2024-02-07",
                   "sequence_type": "FRST",
                   "type": "DEBIT",
                   "updated_at": "2023-03-08 11:41:36"
                 }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
