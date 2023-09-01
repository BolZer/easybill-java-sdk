package com.github.bolzer.easybill_java_sdk.requests;

import com.github.bolzer.easybill_java_sdk.contracts.QueryRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.common.value.qual.IntRange;

@Builder
@Getter
public final class DocumentPaymentListQueryRequest implements QueryRequest {

    @Builder.Default
    @Positive
    private int page = 1;

    @Builder.Default
    @IntRange(from = 100, to = 1000)
    private int limit = 100;

    @Singular
    @NonNull
    private List<@NonNull Long> documentIds;

    @Singular
    @NonNull
    private List<@NonNull String> references;

    @Override
    public @Initialized @NonNull Map<@NonNull String, @NonNull String> toStringMap() {
        final Map<String, String> map = new HashMap<>();

        map.put("page", String.valueOf(page));
        map.put("limit", String.valueOf(limit));

        if (!documentIds.isEmpty()) {
            map.put(
                "document_id",
                String.join(
                    ",",
                    this.documentIds.stream().map(String::valueOf).toList()
                )
            );
        }

        if (!references.isEmpty()) {
            map.put(
                "reference",
                String.join(
                    ",",
                    this.references.stream().map(String::valueOf).toList()
                )
            );
        }

        return map;
    }
}
