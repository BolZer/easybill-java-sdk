package com.github.bolzer.easybill_java_sdk.requests;

import com.github.bolzer.easybill_java_sdk.contracts.QueryRequest;
import lombok.Builder;
import lombok.Getter;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.common.value.qual.IntRange;

import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
public final class GenericListQueryRequest implements QueryRequest {

    @Builder.Default
    @Positive
    private int page = 1;

    @Builder.Default
    @IntRange(from = 100, to = 1000)
    private int limit = 100;

    @Override
    public @Initialized @NonNull Map<@NonNull String, @NonNull String> toStringMap() {
        final Map<String, String> map = new HashMap<>();
        map.put("page", String.valueOf(page));
        map.put("limit", String.valueOf(limit));
        return map;
    }
}
