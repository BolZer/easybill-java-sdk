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
public final class CustomerListQueryRequest implements QueryRequest {

    @Builder.Default
    @Positive
    private int page = 1;

    @Builder.Default
    @IntRange(from = 100, to = 1000)
    private int limit = 100;

    @Singular
    @NonNull
    private List<@NonNull String> numbers;

    @Singular
    @NonNull
    private List<@NonNull String> firstNames;

    @Singular
    @NonNull
    private List<@NonNull String> lastNames;

    @Singular
    @NonNull
    private List<@NonNull String> companyNames;

    @Singular
    @NonNull
    private List<@NonNull String> emails;

    @Singular
    @NonNull
    private List<@NonNull String> zipCodes;

    @Singular
    @NonNull
    private List<@NonNull String> countries;

    @Singular
    @NonNull
    private List<@NonNull Long> groupIds;

    @Singular
    @NonNull
    private List<@NonNull Long> additionalGroupIds;

    @Builder.Default
    @Nullable
    private LocalDate createdAt = null;

    @Builder.Default
    @Nullable
    private Pair<@NonNull LocalDate, @NonNull LocalDate> createdBetween = null;

    @Override
    public @Initialized @NonNull Map<@NonNull String, @NonNull String> toStringMap() {
        final Map<String, String> map = new HashMap<>();

        map.put("page", String.valueOf(page));
        map.put("limit", String.valueOf(limit));

        if (firstNames.size() > 0) {
            map.put(
                "first_name",
                String.join(
                    ",",
                    firstNames.stream().map(String::valueOf).toList()
                )
            );
        }

        if (lastNames.size() > 0) {
            map.put(
                "last_name",
                String.join(
                    ",",
                    lastNames.stream().map(String::valueOf).toList()
                )
            );
        }

        if (companyNames.size() > 0) {
            map.put(
                "company_name",
                String.join(
                    ",",
                    companyNames.stream().map(String::valueOf).toList()
                )
            );
        }

        if (numbers.size() > 0) {
            map.put(
                "number",
                String.join(",", numbers.stream().map(String::valueOf).toList())
            );
        }

        if (emails.size() > 0) {
            map.put(
                "emails",
                String.join(",", emails.stream().map(String::valueOf).toList())
            );
        }

        if (zipCodes.size() > 0) {
            map.put(
                "zip_code",
                String.join(
                    ",",
                    zipCodes.stream().map(String::valueOf).toList()
                )
            );
        }

        if (countries.size() > 0) {
            map.put(
                "country",
                String.join(
                    ",",
                    countries.stream().map(String::valueOf).toList()
                )
            );
        }

        if (groupIds.size() > 0) {
            map.put(
                "group_id",
                String.join(
                    ",",
                    groupIds.stream().map(String::valueOf).toList()
                )
            );
        }

        if (additionalGroupIds.size() > 0) {
            map.put(
                "additional_group_id",
                String.join(
                    ",",
                    additionalGroupIds.stream().map(String::valueOf).toList()
                )
            );
        }

        if (Objects.nonNull(createdAt)) {
            map.put(
                "created_at",
                createdAt.format(DateTimeFormatter.ISO_LOCAL_DATE)
            );
        }

        if (Objects.nonNull(createdBetween)) {
            Pair<@NonNull LocalDate, @NonNull LocalDate> createdBetween =
                Objects.requireNonNull(this.createdBetween);

            map.put(
                "created_at",
                String.join(
                    ",",
                    createdBetween
                        .getValue0()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE),
                    createdBetween
                        .getValue1()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE)
                )
            );
        }

        return map;
    }
}
