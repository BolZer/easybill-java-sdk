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
public final class TimeTrackingListQueryRequest implements QueryRequest {

    @Builder.Default
    @Positive
    private int page = 1;

    @Builder.Default
    @IntRange(from = 100, to = 1000)
    private int limit = 100;

    @Singular
    @NonNull
    private List<@NonNull Long> loginIds;

    @Singular
    @NonNull
    private List<@NonNull Long> projectIds;

    @Builder.Default
    @Nullable
    private LocalDate dateFromAt = null;

    @Builder.Default
    @Nullable
    private Pair<@NonNull LocalDate, @NonNull LocalDate> dateFromBetween = null;

    @Builder.Default
    @Nullable
    private LocalDate dateThruAt = null;

    @Builder.Default
    @Nullable
    private Pair<@NonNull LocalDate, @NonNull LocalDate> dateThruBetween = null;

    @Override
    public @Initialized @NonNull Map<@NonNull String, @NonNull String> toStringMap() {
        final Map<String, String> map = new HashMap<>();
        map.put("page", String.valueOf(page));
        map.put("limit", String.valueOf(limit));

        if (!loginIds.isEmpty()) {
            map.put(
                "login_id",
                String.join(
                    ",",
                    this.loginIds.stream().map(String::valueOf).toList()
                )
            );
        }

        if (!projectIds.isEmpty()) {
            map.put(
                "project_id",
                String.join(
                    ",",
                    this.projectIds.stream().map(String::valueOf).toList()
                )
            );
        }

        if (Objects.nonNull(dateFromAt)) {
            map.put(
                "date_from_at",
                dateFromAt.format(DateTimeFormatter.ISO_LOCAL_DATE)
            );
        }

        if (Objects.nonNull(dateFromBetween)) {
            Pair<@NonNull LocalDate, @NonNull LocalDate> dateFromBetween =
                Objects.requireNonNull(this.dateFromBetween);

            map.put(
                "date_from_at",
                String.join(
                    ",",
                    dateFromBetween
                        .getValue0()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE),
                    dateFromBetween
                        .getValue1()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE)
                )
            );
        }

        if (Objects.nonNull(dateThruAt)) {
            map.put(
                "date_thru_at",
                dateThruAt.format(DateTimeFormatter.ISO_LOCAL_DATE)
            );
        }

        if (Objects.nonNull(dateThruBetween)) {
            Pair<@NonNull LocalDate, @NonNull LocalDate> dateThruBetween =
                Objects.requireNonNull(this.dateThruBetween);

            map.put(
                "date_thru_at",
                String.join(
                    ",",
                    dateThruBetween
                        .getValue0()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE),
                    dateThruBetween
                        .getValue1()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE)
                )
            );
        }

        return map;
    }
}
