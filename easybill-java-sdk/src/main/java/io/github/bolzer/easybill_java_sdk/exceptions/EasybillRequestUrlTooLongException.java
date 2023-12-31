package io.github.bolzer.easybill_java_sdk.exceptions;

import okhttp3.Request;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class EasybillRequestUrlTooLongException
    extends EasybillRestClientException {

    public EasybillRequestUrlTooLongException(
        int responseStatusCode,
        @NonNull String message,
        @NonNull Request request
    ) {
        super(responseStatusCode, message, request);
    }
}
