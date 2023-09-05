package io.github.bolzer.easybill_java_sdk.fixtures.customers;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.CustomerRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class CustomerUpdateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/customers/23";
    }

    public @Nullable Object getPostBody() {
        return CustomerRequest.builder().lastName("something_else").build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                         {
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
                             "cash_allowance_days": null,
                             "cash_discount": null,
                             "cash_discount_type": null,
                             "city": "",
                             "company_name": null,
                             "country": "DE",
                             "court": null,
                             "court_registry_number": null,
                             "created_at": "2023-08-31",
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
                             "display_name": "something",
                             "document_pdf_type": "default",
                             "due_in_days": null,
                             "emails": [],
                             "fax": null,
                             "first_name": "",
                             "foreign_supplier_number": "",
                             "grace_period": null,
                             "group_id": null,
                             "id": 23,
                             "info_1": null,
                             "info_2": null,
                             "internet": null,
                             "last_name": "something_else",
                             "login_id": 32039,
                             "mobile": null,
                             "note": null,
                             "number": "21936",
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
                             "sepa_mandate_reference": "21936",
                             "since_date": null,
                             "state": "",
                             "street": "",
                             "suffix_1": null,
                             "suffix_2": null,
                             "tax_number": null,
                             "tax_options": null,
                             "title": null,
                             "updated_at": "2023-08-31 10:52:14",
                             "vat_identifier": null,
                             "zip_code": ""
                         }
                 """;

        return new MockResponse().setResponseCode(201).setBody(jsonResponse);
    }
}
