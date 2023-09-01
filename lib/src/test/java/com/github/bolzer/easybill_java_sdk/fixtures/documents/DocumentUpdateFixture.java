package com.github.bolzer.easybill_java_sdk.fixtures.documents;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import com.github.bolzer.easybill_java_sdk.requests.DocumentRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentUpdateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/documents/2558029173";
    }

    public @Nullable Object getPostBody() {
        return DocumentRequest.builder().title("something_else").build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                  {
                              "address": {
                                  "city": "",
                                  "company_name": "",
                                  "country": "",
                                  "first_name": "",
                                  "last_name": "",
                                  "personal": false,
                                  "salutation": 0,
                                  "state": "",
                                  "street": "",
                                  "suffix_1": "",
                                  "suffix_2": "",
                                  "title": "",
                                  "zip_code": ""
                              },
                              "amount": 0,
                              "amount_net": 0,
                              "attachment_ids": [],
                              "bank_debit_form": null,
                              "billing_country": null,
                              "buyer_reference": "",
                              "calc_vat_from": 0,
                              "cancel_id": null,
                              "cash_allowance": 8,
                              "cash_allowance_days": 5,
                              "cash_allowance_text": null,
                              "coldstorage_due_date": null,
                              "contact_id": null,
                              "contact_label": null,
                              "contact_text": null,
                              "created_at": "2023-08-30 15:26:01",
                              "currency": "EUR",
                              "customer_id": null,
                              "discount": null,
                              "discount_type": null,
                              "document_date": "2023-08-30",
                              "due_date": null,
                              "due_in_days": null,
                              "edited_at": "2023-08-30 15:35:42",
                              "external_id": null,
                              "fulfillment_country": null,
                              "grace_period": null,
                              "id": 2558029173,
                              "is_acceptable_on_public_domain": false,
                              "is_archive": false,
                              "is_cold": false,
                              "is_draft": true,
                              "is_oss": false,
                              "is_replica": false,
                              "item_notes": [],
                              "items": [],
                              "label_address": {
                                  "city": "",
                                  "company_name": "",
                                  "country": "",
                                  "first_name": "",
                                  "last_name": "",
                                  "personal": false,
                                  "salutation": 0,
                                  "state": "",
                                  "street": "",
                                  "suffix_1": "",
                                  "suffix_2": "",
                                  "title": "",
                                  "zip_code": ""
                              },
                              "last_postbox_id": null,
                              "login_id": 192112,
                              "number": null,
                              "order_number": "",
                              "paid_amount": 0,
                              "paid_at": null,
                              "pdf_pages": 0,
                              "pdf_template": "DE",
                              "project_id": null,
                              "ref_id": null,
                              "replica_url": null,
                              "root_id": null,
                              "service_date": {
                                  "type": "DEFAULT",
                                  "date": "2023-08-30",
                                  "date_from": null,
                                  "date_to": null,
                                  "text": null
                              },
                              "shipping_country": null,
                              "status": null,
                              "text": "Vielen Dank f&uuml;r Ihren Auftrag!<br><br>Bitte begleichen Sie den offenen Betrag bis zum %DOKUMENT.DATUM-FAELLIG%.<br><br>Mit freundlichen Gr&uuml;&szlig;en<br><br>%FIRMA.FIRMA%",
                              "text_prefix": "%KUNDE.ANREDE%,<br>nachfolgend berechnen wir Ihnen wie vorab besprochen:",
                              "text_tax": null,
                              "title": "something_else",
                              "type": "INVOICE",
                              "use_shipping_address": false,
                              "vat_country": null,
                              "vat_option": null
                          }
                 """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
