package com.github.bolzer.easybill_java_sdk.fixtures.documents;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import com.github.bolzer.easybill_java_sdk.requests.DocumentRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentFinalizeFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/documents/139/done";
    }

    public @Nullable Object getPostBody() {
        return DocumentRequest
            .builder()
            .title("finalized")
            .customerId(3L)
            .build();
    }

    public @NonNull MockResponse getResponse() {
        var body =
            """
                {
                    "address": {
                        "city": "Kaarst",
                        "company_name": "Max Mustermann GmbH & Co KG",
                        "country": "DE",
                        "first_name": "Max",
                        "last_name": "Mustermann",
                        "personal": false,
                        "salutation": 0,
                        "state": "",
                        "street": "Muster Str. 13",
                        "suffix_1": null,
                        "suffix_2": null,
                        "title": null,
                        "zip_code": "41564"
                    },
                    "amount": 0,
                    "amount_net": 0,
                    "attachment_ids": [],
                    "bank_debit_form": null,
                    "billing_country": "DE",
                    "buyer_reference": "12000000345",
                    "calc_vat_from": 0,
                    "cancel_id": null,
                    "cash_allowance": null,
                    "cash_allowance_days": null,
                    "cash_allowance_text": null,
                    "coldstorage_due_date": null,
                    "contact_id": null,
                    "contact_label": "",
                    "contact_text": "",
                    "created_at": "2023-08-30 15:59:20",
                    "currency": "EUR",
                    "customer_id": 3,
                    "customer_snapshot": {
                        "acquire_options": null,
                        "additional_groups_ids": [],
                        "archived": false,
                        "bank_account": null,
                        "bank_account_owner": null,
                        "bank_bic": null,
                        "bank_code": null,
                        "bank_iban": null,
                        "bank_name": null,
                        "birth_date": null,
                        "buyer_reference": "12000000345",
                        "cash_allowance": null,
                        "cash_allowance_days": null,
                        "cash_discount": null,
                        "cash_discount_type": null,
                        "city": "Kaarst",
                        "company_name": "Max Mustermann GmbH & Co KG",
                        "country": "DE",
                        "court": null,
                        "court_registry_number": null,
                        "created_at": "2023-08-30",
                        "delivery_city": null,
                        "delivery_company_name": null,
                        "delivery_country": null,
                        "delivery_first_name": null,
                        "delivery_last_name": null,
                        "delivery_personal": false,
                        "delivery_salutation": 0,
                        "delivery_state": "",
                        "delivery_street": null,
                        "delivery_suffix_1": null,
                        "delivery_suffix_2": null,
                        "delivery_title": "",
                        "delivery_zip_code": null,
                        "display_name": "Max Mustermann GmbH & Co KG",
                        "document_pdf_type": "default",
                        "due_in_days": null,
                        "emails": [
                            "max.mustermann@easybill.de"
                        ],
                        "fax": "+49 12 345 092 349",
                        "first_name": "Max",
                        "foreign_supplier_number": "",
                        "grace_period": null,
                        "group_id": null,
                        "id": 3,
                        "info_1": null,
                        "info_2": null,
                        "internet": null,
                        "last_name": "Mustermann",
                        "login_id": 32039,
                        "mobile": null,
                        "note": null,
                        "number": "21931",
                        "payment_options": null,
                        "personal": false,
                        "phone_1": null,
                        "phone_2": null,
                        "postbox": null,
                        "postbox_city": null,
                        "postbox_country": null,
                        "postbox_state": "",
                        "postbox_zip_code": null,
                        "sale_price_level": null,
                        "salutation": 0,
                        "sepa_agreement": null,
                        "sepa_agreement_date": null,
                        "sepa_mandate_reference": null,
                        "since_date": null,
                        "state": "",
                        "street": "Muster Str. 13",
                        "suffix_1": null,
                        "suffix_2": null,
                        "tax_number": null,
                        "tax_options": null,
                        "title": null,
                        "updated_at": "2023-08-30 07:18:55",
                        "vat_identifier": "DE000000000",
                        "zip_code": "41564"
                    },
                    "discount": null,
                    "discount_type": null,
                    "document_date": "2023-08-30",
                    "due_date": null,
                    "due_in_days": null,
                    "edited_at": "2023-08-30 15:59:20",
                    "external_id": null,
                    "fulfillment_country": null,
                    "grace_period": null,
                    "id": 139,
                    "is_acceptable_on_public_domain": false,
                    "is_archive": false,
                    "is_cold": false,
                    "is_draft": true,
                    "is_oss": false,
                    "is_replica": false,
                    "item_notes": [],
                    "items": [],
                    "label_address": {
                        "city": null,
                        "company_name": null,
                        "country": null,
                        "first_name": null,
                        "last_name": null,
                        "personal": false,
                        "salutation": 0,
                        "state": "",
                        "street": null,
                        "suffix_1": null,
                        "suffix_2": null,
                        "title": "",
                        "zip_code": null
                    },
                    "last_postbox_id": null,
                    "login_id": 32039,
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
                    "text": "Vielen Dank für Ihren Auftrag!\\n\\nBitte begleichen Sie den offenen Betrag bis zum %DOKUMENT.DATUM-FAELLIG%.\\n\\nMit freundlichen Grüßen\\n\\n%FIRMA.FIRMA%\\n",
                    "text_prefix": "%KUNDE.ANREDE%,\\nnachfolgend berechnen wir Ihnen wie vorab besprochen:\\n",
                    "text_tax": null,
                    "title": "finalized",
                    "type": "INVOICE",
                    "use_shipping_address": false,
                    "vat_country": null,
                    "vat_option": null
                }
                """;

        return new MockResponse().setResponseCode(201).setBody(body);
    }
}
