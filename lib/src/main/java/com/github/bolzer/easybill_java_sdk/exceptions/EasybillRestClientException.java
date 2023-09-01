package com.github.bolzer.easybill_java_sdk.exceptions;

import org.checkerframework.checker.nullness.qual.NonNull;

public final class EasybillRestClientException extends EasybillRestException {

    public EasybillRestClientException(@NonNull String message) {
        super(message);
    }

    public EasybillRestClientException(
        @NonNull String message,
        @NonNull Throwable previous
    ) {
        super(message, previous);
    }
}