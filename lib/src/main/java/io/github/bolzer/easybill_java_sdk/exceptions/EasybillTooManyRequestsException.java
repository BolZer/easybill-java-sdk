package io.github.bolzer.easybill_java_sdk.exceptions;

import lombok.Getter;
import okhttp3.Request;
import org.checkerframework.checker.nullness.qual.NonNull;

@Getter
public final class EasybillTooManyRequestsException
    extends EasybillRestClientException {

    private final int retryAfterInSeconds;

    public EasybillTooManyRequestsException(
        int responseStatusCode,
        int retryAfterInSeconds,
        @NonNull String message,
        @NonNull Request request
    ) {
        super(responseStatusCode, message, request);
        this.retryAfterInSeconds = retryAfterInSeconds;
    }
}
