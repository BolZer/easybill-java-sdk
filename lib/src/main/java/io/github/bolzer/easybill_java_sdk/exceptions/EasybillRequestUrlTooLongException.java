package io.github.bolzer.easybill_java_sdk.exceptions;

import org.checkerframework.checker.nullness.qual.NonNull;

public final class EasybillRequestUrlTooLongException
    extends EasybillRestClientException {

    public EasybillRequestUrlTooLongException(
        @NonNull String message,
        @NonNull Throwable previous
    ) {
        super(message, previous);
    }
}
