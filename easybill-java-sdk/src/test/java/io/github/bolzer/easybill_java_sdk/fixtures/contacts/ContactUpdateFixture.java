package io.github.bolzer.easybill_java_sdk.fixtures.contacts;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.ContactRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class ContactUpdateFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "PUT";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/customers/6/contacts/8";
    }

    public @Nullable Object getPostBody() {
        return ContactRequest.builder().lastName("Something Else").build();
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "city": "Test",
                    "company_name": "Else Company",
                    "country": "DE",
                    "created_at": "2023-09-01 10:05:44",
                    "department": "Something",
                    "emails": [
                        "test@test.de"
                    ],
                    "fax": "",
                    "first_name": "Else",
                    "id": 8,
                    "last_name": "Something Else",
                    "login_id": 32039,
                    "mobile": "+4917280428",
                    "note": "",
                    "personal": false,
                    "phone_1": "",
                    "phone_2": "",
                    "salutation": 0,
                    "state": "",
                    "street": "Test",
                    "suffix_1": "",
                    "suffix_2": "",
                    "title": "",
                    "updated_at": "2023-09-01 10:05:44",
                    "zip_code": ""
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
