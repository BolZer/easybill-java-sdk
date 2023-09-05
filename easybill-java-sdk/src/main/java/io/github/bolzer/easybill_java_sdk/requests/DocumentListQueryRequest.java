package io.github.bolzer.easybill_java_sdk.requests;

import io.github.bolzer.easybill_java_sdk.contracts.QueryRequest;
import io.github.bolzer.easybill_java_sdk.enums.DocumentType;
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

@Builder
@Getter
public final class DocumentListQueryRequest implements QueryRequest {

    @Builder.Default
    @Positive
    private int page = 1;

    @Builder.Default
    @IntRange(from = 100, to = 1000)
    private int limit = 100;

    @Builder.Default
    @Nullable
    private Boolean isDraft = null;

    @Builder.Default
    @Nullable
    private Boolean isArchive = null;

    @Builder.Default
    @Nullable
    private Long refId = null;

    @Builder.Default
    @Nullable
    private LocalDate documentDate = null;

    @Builder.Default
    @Nullable
    private LocalDate paidAt = null;

    @Nullable
    @Builder.Default
    private String title = null;

    @Nullable
    @Builder.Default
    private String number = null;

    @Nullable
    @Builder.Default
    private String fulfillmentCountry = null;

    @Nullable
    @Builder.Default
    private String vatCountry = null;

    @Nullable
    @Builder.Default
    private String shippingCountry = null;

    @Nullable
    @Builder.Default
    private String status = null;

    @Singular
    @NonNull
    private List<@NonNull Long> customerIds;

    @Singular
    @NonNull
    private List<@NonNull Long> projectIds;

    @Singular
    @NonNull
    private List<@NonNull Long> cancelIds;

    @Singular
    @NonNull
    private List<@NonNull DocumentType> types;

    @Override
    public @Initialized @NonNull Map<@NonNull String, @NonNull String> toStringMap() {
        final Map<String, String> map = new HashMap<>();

        map.put("page", String.valueOf(page));
        map.put("limit", String.valueOf(limit));

        if (Objects.nonNull(isDraft)) {
            map.put("is_draft", isDraft ? "1" : "0");
        }

        if (Objects.nonNull(isArchive)) {
            map.put("is_archive", isArchive ? "1" : "0");
        }

        if (Objects.nonNull(refId)) {
            map.put("ref_id", String.valueOf(refId));
        }

        if (Objects.nonNull(documentDate)) {
            map.put(
                "document_date",
                documentDate.format(DateTimeFormatter.ISO_DATE)
            );
        }

        if (Objects.nonNull(paidAt)) {
            map.put("paid_at", paidAt.format(DateTimeFormatter.ISO_DATE));
        }

        if (Objects.nonNull(title)) {
            map.put("title", title);
        }

        if (Objects.nonNull(number)) {
            map.put("number", number);
        }

        if (Objects.nonNull(number)) {
            map.put("number", number);
        }

        if (Objects.nonNull(fulfillmentCountry)) {
            map.put("fulfillment_country", fulfillmentCountry);
        }

        if (Objects.nonNull(vatCountry)) {
            map.put("vat_country", vatCountry);
        }

        if (Objects.nonNull(shippingCountry)) {
            map.put("shipping_country", shippingCountry);
        }

        if (Objects.nonNull(status)) {
            map.put("status", status);
        }

        if (!customerIds.isEmpty()) {
            map.put(
                "customer_id",
                String.join(
                    ",",
                    this.customerIds.stream().map(String::valueOf).toList()
                )
            );
        }

        if (!projectIds.isEmpty()) {
            map.put(
                "project_id",
                String.join(
                    ",",
                    this.customerIds.stream().map(String::valueOf).toList()
                )
            );
        }

        if (!cancelIds.isEmpty()) {
            map.put(
                "cancel_id",
                String.join(
                    ",",
                    this.cancelIds.stream().map(String::valueOf).toList()
                )
            );
        }

        if (!types.isEmpty()) {
            map.put(
                "type",
                String.join(
                    ",",
                    this.types.stream().map(String::valueOf).toList()
                )
            );
        }

        return map;
    }
}
