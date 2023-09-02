package io.github.bolzer.easybill_java_sdk.exceptions;

import org.checkerframework.checker.nullness.qual.NonNull;

public sealed class EasybillRestClientException
    extends EasybillRestException
    permits
        EasybillBadRequestException,
        EasybillTooManyRequestsException,
        EasybillRequestUrlTooLongException {

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
