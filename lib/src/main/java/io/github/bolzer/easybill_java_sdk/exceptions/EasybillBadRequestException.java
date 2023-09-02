package io.github.bolzer.easybill_java_sdk.exceptions;

import org.checkerframework.checker.nullness.qual.NonNull;

public final class EasybillBadRequestException
    extends EasybillRestClientException {

    public EasybillBadRequestException(
        @NonNull String message,
        @NonNull Throwable previous
    ) {
        super(message, previous);
    }
}
