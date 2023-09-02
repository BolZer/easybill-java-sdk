package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.Login;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class LoginResource {

    @NonNull
    public static final String RESOURCE_URL = "/logins";

    @NonNull
    private final HttpClient httpClient;

    public LoginResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<Login> fetchLogins(
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Login fetchLogin(@Positive long loginId)
        throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL + "/" + loginId,
                null,
                new TypeReference<>() {}
            );
    }
}
