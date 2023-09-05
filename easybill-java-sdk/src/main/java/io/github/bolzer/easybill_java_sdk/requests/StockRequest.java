package io.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class StockRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private StockRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static StockRequestBuilder builder() {
        return new StockRequestBuilder();
    }

    public static class StockRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public StockRequest build() {
            return new StockRequest(this.parameters);
        }

        public StockRequestBuilder note(@NonNull String note) {
            this.parameters.put("note", note);
            return this;
        }

        public StockRequestBuilder stockCount(long stockCount) {
            this.parameters.put("stock_count", stockCount);
            return this;
        }

        public StockRequestBuilder positionId(long positionId) {
            this.parameters.put("position_id", positionId);
            return this;
        }

        public StockRequestBuilder storedAt(@NonNull LocalDateTime storedAt) {
            this.parameters.put(
                    "stored_at",
                    storedAt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                );
            return this;
        }
    }
}
