package io.github.bolzer.easybill_java_sdk.responses;

import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.NonNull;

public record PaginatedResponse<T>(
    int page,
    int pages,
    int limit,
    int total,
    List<@NonNull T> items
) {
    public PaginatedResponse(
        int page,
        int pages,
        int limit,
        int total,
        List<@NonNull T> items
    ) {
        this.page = page;
        this.pages = pages;
        this.limit = limit;
        this.total = total;
        this.items = Collections.unmodifiableList(items);
    }
}
