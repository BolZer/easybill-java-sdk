package io.github.bolzer.easybill_java_sdk.fixtures.documents;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentFetchListFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/documents?limit=2&page=1";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "page": 1,
                    "pages": 1179,
                    "limit": 2,
                    "total": 2357,
                    "items": [
                        {
                            "address": {
                                "city": "",
                                "company_name": "sfsdfsdf",
                                "country": "DE",
                                "first_name": "",
                                "last_name": "",
                                "personal": false,
                                "salutation": 0,
                                "state": "",
                                "street": "",
                                "suffix_1": null,
                                "suffix_2": null,
                                "title": null,
                                "zip_code": ""
                            },
                            "amount": 0,
                            "amount_net": 0,
                            "attachment_ids": [],
                            "bank_debit_form": null,
                            "billing_country": "DE",
                            "buyer_reference": "",
                            "calc_vat_from": 0,
                            "cancel_id": 1915981408,
                            "cash_allowance": 13,
                            "cash_allowance_days": 2,
                            "cash_allowance_text": null,
                            "coldstorage_due_date": null,
                            "contact_id": null,
                            "contact_label": null,
                            "contact_text": null,
                            "created_at": "2018-09-19 13:53:32",
                            "currency": "EUR",
                            "customer_id": 232011343,
                            "customer_snapshot": {
                                "acquire_options": 1,
                                "additional_groups_ids": [],
                                "archived": false,
                                "bank_account": null,
                                "bank_account_owner": null,
                                "bank_bic": null,
                                "bank_code": null,
                                "bank_iban": null,
                                "bank_name": null,
                                "birth_date": null,
                                "buyer_reference": "",
                                "cash_allowance": null,
                                "cash_allowance_days": 7,
                                "cash_discount": null,
                                "cash_discount_type": null,
                                "city": "",
                                "company_name": "sfsdfsdf",
                                "country": "DE",
                                "court": null,
                                "court_registry_number": null,
                                "created_at": "2018-09-19",
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
                                "display_name": "sfsdfsdf",
                                "document_pdf_type": "default",
                                "due_in_days": null,
                                "emails": [],
                                "fax": null,
                                "first_name": "",
                                "foreign_supplier_number": "",
                                "grace_period": null,
                                "group_id": null,
                                "id": 232011343,
                                "info_1": null,
                                "info_2": null,
                                "internet": null,
                                "last_name": "",
                                "login_id": 32039,
                                "mobile": null,
                                "note": null,
                                "number": "X 14665",
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
                                "street": "",
                                "suffix_1": null,
                                "suffix_2": null,
                                "tax_number": null,
                                "tax_options": null,
                                "title": null,
                                "updated_at": "2018-09-19 13:53:42",
                                "vat_identifier": null,
                                "zip_code": ""
                            },
                            "discount": null,
                            "discount_type": null,
                            "document_date": "2018-09-19",
                            "due_date": "2018-09-19",
                            "due_in_days": 0,
                            "edited_at": "2022-06-24 15:14:56",
                            "external_id": null,
                            "fulfillment_country": null,
                            "grace_period": 0,
                            "id": 293594830,
                            "is_acceptable_on_public_domain": false,
                            "is_archive": false,
                            "is_cold": false,
                            "is_draft": false,
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
                            "last_postbox_id": 202718584,
                            "login_id": 32039,
                            "number": "2000003340",
                            "order_number": "",
                            "paid_amount": 0,
                            "paid_at": null,
                            "pdf_pages": 1,
                            "pdf_template": "DE",
                            "project_id": null,
                            "ref_id": null,
                            "replica_url": null,
                            "root_id": null,
                            "service_date": {
                                "type": "DEFAULT",
                                "date": "2018-09-19",
                                "date_from": null,
                                "date_to": null,
                                "text": null
                            },
                            "shipping_country": null,
                            "status": null,
                            "text": "Vielen Dank für Ihren Auftrag!<br><br>Bitte begleichen Sie den offenen Betrag bis zum %DOKUMENT.DATUM-FAELLIG%.<br><br>Mit freundlichen Grüßen<br><br>%FIRMA.FIRMA%<br>",
                            "text_prefix": "%KUNDE.ANREDE%,<br>nachfolgend berechnen wir Ihnen wie vorab besprochen:<br>",
                            "text_tax": null,
                            "title": null,
                            "type": "INVOICE",
                            "use_shipping_address": false,
                            "vat_country": null,
                            "vat_option": null
                        },
                        {
                            "address": {
                                "city": "",
                                "company_name": "Test",
                                "country": "DE",
                                "first_name": "",
                                "last_name": "",
                                "personal": false,
                                "salutation": 0,
                                "state": "",
                                "street": "",
                                "suffix_1": null,
                                "suffix_2": null,
                                "title": null,
                                "zip_code": ""
                            },
                            "amount": 10000,
                            "amount_net": 10000,
                            "attachment_ids": [],
                            "bank_debit_form": null,
                            "billing_country": "DE",
                            "buyer_reference": "",
                            "calc_vat_from": 0,
                            "cancel_id": 297745687,
                            "cash_allowance": 13,
                            "cash_allowance_days": 2,
                            "cash_allowance_text": null,
                            "coldstorage_due_date": null,
                            "contact_id": null,
                            "contact_label": null,
                            "contact_text": null,
                            "created_at": "2018-09-26 08:00:24",
                            "currency": "EUR",
                            "customer_id": 232037662,
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
                                "buyer_reference": "",
                                "cash_allowance": null,
                                "cash_allowance_days": 0,
                                "cash_discount": null,
                                "cash_discount_type": null,
                                "city": "",
                                "company_name": "Test",
                                "country": "DE",
                                "court": null,
                                "court_registry_number": null,
                                "created_at": "2018-09-19",
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
                                "display_name": "Test",
                                "document_pdf_type": "default",
                                "due_in_days": null,
                                "emails": [],
                                "fax": null,
                                "first_name": "",
                                "foreign_supplier_number": "",
                                "grace_period": null,
                                "group_id": null,
                                "id": 232037662,
                                "info_1": null,
                                "info_2": null,
                                "internet": null,
                                "last_name": "",
                                "login_id": 151948,
                                "mobile": null,
                                "note": null,
                                "number": "X 14666",
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
                                "street": "",
                                "suffix_1": null,
                                "suffix_2": null,
                                "tax_number": null,
                                "tax_options": null,
                                "title": null,
                                "updated_at": "2018-09-19 16:44:25",
                                "vat_identifier": null,
                                "zip_code": ""
                            },
                            "discount": null,
                            "discount_type": null,
                            "document_date": "2017-04-13",
                            "due_date": "2017-04-13",
                            "due_in_days": 0,
                            "edited_at": "2023-07-24 01:40:33",
                            "external_id": null,
                            "fulfillment_country": null,
                            "grace_period": 0,
                            "id": 295629370,
                            "is_acceptable_on_public_domain": false,
                            "is_archive": false,
                            "is_cold": false,
                            "is_draft": false,
                            "is_oss": false,
                            "is_replica": false,
                            "item_notes": [],
                            "items": [
                                {
                                    "booking_account": null,
                                    "cost_price_charge": null,
                                    "cost_price_charge_type": "AMOUNT",
                                    "cost_price_net": null,
                                    "cost_price_total": null,
                                    "description": "gdsfgdsf",
                                    "discount": null,
                                    "discount_type": null,
                                    "document_note": null,
                                    "export_cost_1": null,
                                    "export_cost_2": null,
                                    "id": 572212351,
                                    "item_type": "PRODUCT",
                                    "number": "1",
                                    "position": 1,
                                    "position_id": null,
                                    "quantity": 1,
                                    "quantity_str": "1",
                                    "serial_number": null,
                                    "serial_number_id": null,
                                    "single_price_gross": 10000,
                                    "single_price_net": 10000,
                                    "total_price_gross": 10000,
                                    "total_price_net": 10000,
                                    "total_vat": 0,
                                    "type": "POSITION",
                                    "unit": null,
                                    "vat_percent": 0
                                }
                            ],
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
                            "number": "2000003341",
                            "order_number": "",
                            "paid_amount": 0,
                            "paid_at": null,
                            "pdf_pages": 1,
                            "pdf_template": "DE",
                            "project_id": null,
                            "ref_id": null,
                            "replica_url": null,
                            "root_id": null,
                            "service_date": {
                                "type": "DEFAULT",
                                "date": "2017-04-13",
                                "date_from": null,
                                "date_to": null,
                                "text": null
                            },
                            "shipping_country": null,
                            "status": null,
                            "text": "Vielen Dank für Ihren Auftrag!<br><br>Bitte begleichen Sie den offenen Betrag bis zum %DOKUMENT.DATUM-FAELLIG%.<br><br>Mit freundlichen Grüßen<br><br>%FIRMA.FIRMA%",
                            "text_prefix": "%KUNDE.ANREDE%,<br>nachfolgend berechnen wir Ihnen wie vorab besprochen:",
                            "text_tax": null,
                            "title": "rechnung 1",
                            "type": "INVOICE",
                            "use_shipping_address": false,
                            "vat_country": null,
                            "vat_option": null
                        }
                    ]
                }""";

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
