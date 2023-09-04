package io.github.bolzer.easybill_java_sdk.exceptions;

import lombok.Getter;
import org.checkerframework.checker.nullness.qual.NonNull;

@Getter
public final class EasybillRestServerException extends EasybillRestException {

    private final int responseStatusCode;

    public EasybillRestServerException(
        int responseStatusCode,
        @NonNull String message
    ) {
        super(message);
        this.responseStatusCode = responseStatusCode;
    }
}
