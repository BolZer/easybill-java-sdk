package com.github.bolzer.easybill_java_sdk.contracts;

import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Map;

public interface QueryRequest {
    @Initialized
    @NonNull
    Map<@NonNull String, @NonNull String> toStringMap();
}
