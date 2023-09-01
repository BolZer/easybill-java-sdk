package com.github.bolzer.easybill_java_sdk.contracts;

import java.util.Map;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface QueryRequest {
    @Initialized
    @NonNull
    Map<@NonNull String, @NonNull String> toStringMap();
}
