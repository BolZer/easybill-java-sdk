package io.github.bolzer.easybill_java_sdk.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import java.io.File;
import java.nio.ByteBuffer;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface HttpClient {
    @NonNull
    ByteBuffer requestGetBytes(@NonNull String endpoint)
        throws EasybillRestException;

    @NonNull
    <T extends @Initialized @NonNull Object> T requestGetJson(
        @NonNull String endpoint,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException;

    @NonNull
    <T extends @Initialized @NonNull Object> T requestGetJson(
        @NonNull String endpoint,
        @NonNull QueryRequest queryRequest,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException;

    void requestPostEmpty(@NonNull String endpoint)
        throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T requestPostFile(
        @NonNull String endpoint,
        @NonNull File file,
        TypeReference<T> typeReference
    ) throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T requestPostJson(
        @NonNull String endpoint,
        @NonNull Object payload,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T requestPostJson(
        @NonNull String endpoint,
        @NonNull QueryRequest queryRequest,
        @NonNull Object payload,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException;

    void requestPostJson(@NonNull String endpoint, @NonNull Object payload)
        throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T requestPutJson(
        @NonNull String endpoint,
        @NonNull Object payload,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T requestPutJson(
        @NonNull String endpoint,
        @NonNull QueryRequest queryRequest,
        @NonNull Object payload,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException;

    void requestDelete(@NonNull String endpoint) throws EasybillRestException;
}
