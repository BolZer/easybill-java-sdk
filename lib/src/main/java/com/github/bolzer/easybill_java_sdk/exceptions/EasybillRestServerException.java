package com.github.bolzer.easybill_java_sdk.exceptions;

import org.checkerframework.checker.nullness.qual.NonNull;

public final class EasybillRestServerException extends EasybillRestException {

    public EasybillRestServerException(@NonNull String message) {
        super(message);
    }

    public EasybillRestServerException(
        @NonNull String message,
        @NonNull Throwable previous
    ) {
        super(message, previous);
    }
}
