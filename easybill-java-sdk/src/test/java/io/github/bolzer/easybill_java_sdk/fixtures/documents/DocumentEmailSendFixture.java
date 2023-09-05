package io.github.bolzer.easybill_java_sdk.fixtures.documents;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.DocumentSendRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentEmailSendFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/documents/2558029173/send/email";
    }

    public @Nullable Object getPostBody() {
        return DocumentSendRequest
            .builder()
            .subject("Test Message")
            .message("Test Message Content")
            .from("dev@easybill.de")
            .to("random@test.de")
            .sendBySelf(false)
            .build();
    }

    public @NonNull MockResponse getResponse() {
        return new MockResponse().setResponseCode(204);
    }
}
