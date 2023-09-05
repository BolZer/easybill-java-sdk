package io.github.bolzer.easybill_java_sdk.requests;

import io.github.bolzer.easybill_java_sdk.contracts.QueryRequest;
import io.github.bolzer.easybill_java_sdk.enums.ItemType;
import io.github.bolzer.easybill_java_sdk.enums.PostBoxStatus;
import io.github.bolzer.easybill_java_sdk.enums.PostBoxType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.common.value.qual.IntRange;

@Builder
@Getter
public final class PostBoxListQueryRequest implements QueryRequest {

    @Builder.Default
    @Positive
    private int page = 1;

    @Builder.Default
    @IntRange(from = 100, to = 1000)
    private int limit = 100;

    @Builder.Default
    @Nullable
    private ItemType type = null;

    @Builder.Default
    @Nullable
    private PostBoxStatus status = null;

    @Singular
    @NonNull
    private List<@NonNull PostBoxType> types;

    @Singular
    @NonNull
    private List<@NonNull Long> documentIds;

    @Override
    public @Initialized @NonNull Map<@NonNull String, @NonNull String> toStringMap() {
        final Map<String, String> map = new HashMap<>();
        map.put("page", String.valueOf(page));
        map.put("limit", String.valueOf(limit));

        if (Objects.nonNull(status)) {
            map.put("status", status.getValue());
        }

        if (!types.isEmpty()) {
            map.put(
                "type",
                String.join(
                    ",",
                    this.types.stream().map(PostBoxType::getValue).toList()
                )
            );
        }

        if (!documentIds.isEmpty()) {
            map.put(
                "document_id",
                String.join(
                    ",",
                    this.documentIds.stream().map(String::valueOf).toList()
                )
            );
        }

        return map;
    }
}
