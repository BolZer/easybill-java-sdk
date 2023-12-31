package io.github.bolzer.easybill_java_sdk.fixtures.logins;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class LoginFetchListFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/logins?limit=1&page=1";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "page": 1,
                    "pages": 8,
                    "limit": 1,
                    "total": 8,
                    "items": [
                        {
                            "display_name": "Max Mustermann",
                            "email": "mustermann@easybill.de",
                            "email_signature": "",
                            "first_name": "Max",
                            "id": 2,
                            "last_name": "Mustermann",
                            "locale": "de",
                            "login_type": "ADMIN",
                            "phone": "",
                            "security": {
                                "two_factor_enabled": false,
                                "notify_on_new_login_enabled": true,
                                "recovery_codes_enabled": true
                            },
                            "time_zone": "Europe/Berlin"
                        }
                    ]
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
