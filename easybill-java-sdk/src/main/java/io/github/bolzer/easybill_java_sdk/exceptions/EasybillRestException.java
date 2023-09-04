package io.github.bolzer.easybill_java_sdk.exceptions;

import org.checkerframework.checker.nullness.qual.NonNull;

public sealed class EasybillRestException
    extends Exception
    permits EasybillRestClientException, EasybillRestServerException {

    public EasybillRestException(@NonNull String message) {
        super(message);
    }

    public EasybillRestException(
        @NonNull String message,
        @NonNull Throwable previous
    ) {
        super(message, previous);
    }
}
