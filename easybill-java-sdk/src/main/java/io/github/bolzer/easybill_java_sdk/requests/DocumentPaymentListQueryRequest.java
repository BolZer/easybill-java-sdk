package io.github.bolzer.easybill_java_sdk.requests;

import io.github.bolzer.easybill_java_sdk.contracts.QueryRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.javatuples.Pair;

@Builder
@Getter
public final class DocumentPaymentListQueryRequest implements QueryRequest {

    @Builder.Default
    @Positive
    private int page = 1;

    @Builder.Default
    @IntRange(from = 100, to = 1000)
    private int limit = 100;

    @Builder.Default
    @Nullable
    private LocalDate paymentAt = null;

    @Builder.Default
    @Nullable
    private Pair<@NonNull LocalDate, @NonNull LocalDate> paymentBetween = null;

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
            map.put("references", String.join(",", this.references));
        }

        if (Objects.nonNull(paymentAt)) {
            map.put(
                "payment_at",
                paymentAt.format(DateTimeFormatter.ISO_LOCAL_DATE)
            );
        }

        if (Objects.nonNull(paymentBetween)) {
            Pair<@NonNull LocalDate, @NonNull LocalDate> paymentBetween =
                Objects.requireNonNull(this.paymentBetween);

            map.put(
                "created_at",
                String.join(
                    ",",
                    paymentBetween
                        .getValue0()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE),
                    paymentBetween
                        .getValue1()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE)
                )
            );
        }

        return map;
    }
}
