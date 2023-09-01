package com.github.bolzer.easybill_java_sdk.interceptors;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.IOException;

public final class UserAgentInterceptor implements Interceptor {

    @NonNull
    final String userAgent;

    public UserAgentInterceptor(@NonNull String userAgent) {
        this.userAgent = userAgent;
    }

    @NonNull
    @Override
    public Response intercept(Interceptor.@NonNull Chain chain)
        throws IOException {
        Request requestWithUserAgent = chain
            .request()
            .newBuilder()
            .header("User-Agent", this.userAgent)
            .build();

        return chain.proceed(requestWithUserAgent);
    }
}
