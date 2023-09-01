package com.github.bolzer.easybill_java_sdk.fixtures.customers;

import com.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class CustomerFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/customers/14";
    }

    public @Nullable Object getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                            {
                                "acquire_options": null,
                                "additional_groups_ids": [
                                    6
                                ],
                                "archived": false,
                                "bank_account": null,
                                "bank_account_owner": null,
                                "bank_bic": null,
                                "bank_code": null,
                                "bank_iban": null,
                                "bank_name": null,
                                "birth_date": "1999-01-31",
                                "buyer_reference": "",
                                "cash_allowance": null,
                                "cash_allowance_days": null,
                                "cash_discount": null,
                                "cash_discount_type": null,
                                "city": "Leipzig",
                                "company_name": null,
                                "country": "DE",
                                "court": null,
                                "court_registry_number": null,
                                "created_at": "2019-04-13",
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
                                "display_name": "Maria Diaz Trujillo",
                                "document_pdf_type": "default",
                                "due_in_days": null,
                                "emails": [
                                    "mdt@easybill.de"
                                ],
                                "fax": null,
                                "first_name": "Maria",
                                "foreign_supplier_number": "",
                                "grace_period": null,
                                "group_id": null,
                                "id": 14,
                                "info_1": null,
                                "info_2": null,
                                "internet": null,
                                "last_name": "Diaz Trujillo",
                                "login_id": 33666,
                                "mobile": null,
                                "note": null,
                                "number": "21946",
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
                                "street": "Karl-Liebknecht-Strasse 237",
                                "suffix_1": null,
                                "suffix_2": null,
                                "tax_number": null,
                                "tax_options": null,
                                "title": null,
                                "updated_at": "2023-08-31 07:41:48",
                                "vat_identifier": null,
                                "zip_code": "2115"
                            }
                        """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
