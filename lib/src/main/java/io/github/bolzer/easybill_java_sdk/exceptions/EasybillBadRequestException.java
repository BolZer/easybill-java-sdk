package io.github.bolzer.easybill_java_sdk.exceptions;

import java.util.Collections;
import java.util.List;
import lombok.Getter;
import okhttp3.Request;
import org.checkerframework.checker.nullness.qual.NonNull;

@Getter
public final class EasybillBadRequestException
    extends EasybillRestClientException {

    private final int internalErrorCode;

    @NonNull
    private final List<@NonNull String> arguments;

    public EasybillBadRequestException(
        int internalErrorCode,
        @NonNull List<@NonNull String> arguments,
        @NonNull String message,
        @NonNull Request request
    ) {
        super(message, request);
        this.internalErrorCode = internalErrorCode;
        this.arguments = Collections.unmodifiableList(arguments);
    }
}
