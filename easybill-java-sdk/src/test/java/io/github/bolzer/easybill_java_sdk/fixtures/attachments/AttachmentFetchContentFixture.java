package io.github.bolzer.easybill_java_sdk.fixtures.attachments;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class AttachmentFetchContentFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/attachments/1/content";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String binaryResponseAsString = "1\n2\n3\n4\n5";

        return new MockResponse()
            .setResponseCode(200)
            .setBody(binaryResponseAsString);
    }
}
