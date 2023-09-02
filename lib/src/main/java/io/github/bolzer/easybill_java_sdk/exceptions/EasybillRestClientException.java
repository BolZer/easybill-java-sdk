package io.github.bolzer.easybill_java_sdk.exceptions;

import lombok.Getter;
import okhttp3.Request;
import org.checkerframework.checker.nullness.qual.NonNull;

@Getter
public sealed class EasybillRestClientException
    extends EasybillRestException
    permits
        EasybillBadRequestException,
        EasybillTooManyRequestsException,
        EasybillRequestUrlTooLongException {

    private final Request request;

    public EasybillRestClientException(
        @NonNull String message,
        @NonNull Request request
    ) {
        super(message);
        this.request = request;
    }
}
