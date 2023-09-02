package io.github.bolzer.easybill_java_sdk.fixtures.contact;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class ContactFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/customers/6/contacts/1";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "city": "Essen",
                    "company_name": "WAT",
                    "country": "DE",
                    "created_at": "2023-09-01 08:00:14",
                    "department": "IT",
                    "emails": [
                        "something@test.de"
                    ],
                    "fax": "0000000",
                    "first_name": "Something",
                    "id": 1,
                    "last_name": "Else",
                    "login_id": 32039,
                    "mobile": "010000000",
                    "note": "",
                    "personal": false,
                    "phone_1": "+49 2154 00000 00",
                    "phone_2": "",
                    "salutation": 1,
                    "state": "",
                    "street": "Teststreet",
                    "suffix_1": "",
                    "suffix_2": "",
                    "title": "",
                    "updated_at": "2023-09-01 08:00:14",
                    "zip_code": "123512"
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
