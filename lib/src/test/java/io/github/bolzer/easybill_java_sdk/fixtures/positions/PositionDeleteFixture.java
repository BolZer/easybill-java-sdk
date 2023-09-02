package io.github.bolzer.easybill_java_sdk.fixtures.positions;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PositionDeleteFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "DELETE";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/positions/43";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        return new MockResponse().setResponseCode(204);
    }
}
