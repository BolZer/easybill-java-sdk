package io.github.bolzer.easybill_java_sdk.contracts;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import java.io.File;
import java.nio.ByteBuffer;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface HttpClient {
    @NonNull
    ByteBuffer getBytes(@NonNull String endpoint) throws EasybillRestException;

    @NonNull
    <T extends @Initialized @NonNull Object> T getJson(
        @NonNull String endpoint,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException;

    @NonNull
    <T extends @Initialized @NonNull Object> T getJson(
        @NonNull String endpoint,
        @NonNull QueryRequest queryRequest,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException;

    void postEmpty(@NonNull String endpoint) throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T postFile(
        @NonNull String endpoint,
        @NonNull File file,
        TypeReference<T> typeReference
    ) throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T postJson(
        @NonNull String endpoint,
        @NonNull Object payload,
        TypeReference<T> typeReference
    ) throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T postJson(
        @NonNull String endpoint,
        @NonNull QueryRequest queryRequest,
        @NonNull Object payload,
        TypeReference<T> typeReference
    ) throws EasybillRestException;

    void postJson(@NonNull String endpoint, @NonNull Object payload)
        throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T putJson(
        @NonNull String endpoint,
        @NonNull Object payload,
        TypeReference<T> typeReference
    ) throws EasybillRestException;

    <T extends @Initialized @NonNull Object> T putJson(
        @NonNull String endpoint,
        @NonNull QueryRequest queryRequest,
        @NonNull Object payload,
        TypeReference<T> typeReference
    ) throws EasybillRestException;

    void delete(@NonNull String endpoint) throws EasybillRestException;
}
