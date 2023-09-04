package io.github.bolzer.easybill_java_sdk.fixtures;

import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface Fixture {
    @NonNull
    String getRequestMethod();

    @NonNull
    String getRequestUrl();

    @Nullable
    Object getPostBody();

    @NonNull
    MockResponse getResponse();
}
