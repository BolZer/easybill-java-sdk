package com.github.bolzer.easybill_java_sdk.interceptors;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.IOException;

public final class BearerAuthorizationInterceptor implements Interceptor {

    @NonNull
    private final String bearerToken;

    public BearerAuthorizationInterceptor(@NonNull String bearerToken) {
        this.bearerToken = bearerToken;
    }

    @NonNull
    @Override
    public Response intercept(Interceptor.@NonNull Chain chain)
        throws IOException {
        Request requestWithAuthorization = chain
            .request()
            .newBuilder()
            .header("Authorization", "Bearer " + this.bearerToken)
            .build();

        return chain.proceed(requestWithAuthorization);
    }
}
