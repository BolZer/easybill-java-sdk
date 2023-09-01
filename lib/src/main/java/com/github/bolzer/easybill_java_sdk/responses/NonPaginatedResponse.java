package com.github.bolzer.easybill_java_sdk.responses;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collections;
import java.util.List;

public record NonPaginatedResponse<T>(List<@NonNull T> items) {
    public NonPaginatedResponse(List<@NonNull T> items) {
        this.items = Collections.unmodifiableList(items);
    }
}
