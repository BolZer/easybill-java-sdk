package com.github.bolzer.easybill_java_sdk.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface HttpClient {
    @NonNull
    <T extends @Initialized @NonNull Object> T doGetRequestAndMarshalJsonInto(
        @NonNull String endpoint,
        @Nullable QueryRequest request,
        TypeReference<T> typeReferenceOfReturnValue
    ) throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T doPostRequestAndMarshalJsonInto(
        @NonNull String endpoint,
        @NonNull Object payload,
        TypeReference<T> typeReferenceOfReturnValue
    ) throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T doPutRequestAndMarshalJsonInto(
        @NonNull String endpoint,
        @NonNull Object payload,
        TypeReference<T> typeReferenceOfReturnValue
    ) throws EasybillRestException;

    void doDeleteRequest(@NonNull String endpoint) throws EasybillRestException;

    void doPostRequestWithoutPayload(@NonNull String endpoint)
        throws EasybillRestException;

    void doPostRequestWithPayload(
        @NonNull String endpoint,
        @NonNull Object payload
    ) throws EasybillRestException;

    byte[] downloadFile(@NonNull String endpoint) throws EasybillRestException;
}
