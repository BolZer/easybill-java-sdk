package io.github.bolzer.easybill_java_sdk.responses;

import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.NonNull;

public record NonPaginatedResponse<T>(List<@NonNull T> items) {
    public NonPaginatedResponse(List<@NonNull T> items) {
        this.items = Collections.unmodifiableList(items);
    }
}
