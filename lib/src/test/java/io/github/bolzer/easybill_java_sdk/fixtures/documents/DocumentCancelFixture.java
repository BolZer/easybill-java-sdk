package io.github.bolzer.easybill_java_sdk.fixtures.documents;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentCancelFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/documents/2558029173/cancel";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        return new MockResponse().setResponseCode(201);
    }
}
