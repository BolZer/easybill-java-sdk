package io.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class TimeTrackingRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private TimeTrackingRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static TimeTrackingRequestBuilder builder() {
        return new TimeTrackingRequestBuilder();
    }

    public static class TimeTrackingRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public TimeTrackingRequest build() {
            return new TimeTrackingRequest(this.parameters);
        }

        public TimeTrackingRequestBuilder description(
            @NonNull String description
        ) {
            this.parameters.put("description", description);
            return this;
        }

        public TimeTrackingRequestBuilder number(@NonNull String number) {
            this.parameters.put("number", number);
            return this;
        }

        public TimeTrackingRequestBuilder note(@NonNull String note) {
            this.parameters.put("note", note);
            return this;
        }

        public TimeTrackingRequestBuilder hourlyRate(long hourlyRate) {
            this.parameters.put("hourly_rate", hourlyRate);
            return this;
        }

        public TimeTrackingRequestBuilder timerValue(long timerValue) {
            this.parameters.put("timer_value", timerValue);
            return this;
        }

        public TimeTrackingRequestBuilder projectId(@Nullable Long projectId) {
            this.parameters.put("project_id", projectId);
            return this;
        }

        public TimeTrackingRequestBuilder positionId(
            @Nullable Long position_id
        ) {
            this.parameters.put("position_id", position_id);
            return this;
        }

        public TimeTrackingRequestBuilder clearedAt(
            @Nullable LocalDateTime clearedAt
        ) {
            if (clearedAt == null) {
                this.parameters.put("cleared_at", null);
                return this;
            }

            this.parameters.put(
                    "cleared_at",
                    clearedAt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                );
            return this;
        }

        public TimeTrackingRequestBuilder dateFromAt(
            @Nullable LocalDateTime dateFromAt
        ) {
            if (dateFromAt == null) {
                this.parameters.put("date_from_at", null);
                return this;
            }

            this.parameters.put(
                    "date_from_at",
                    dateFromAt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                );
            return this;
        }

        public TimeTrackingRequestBuilder dateThruAt(
            @Nullable LocalDateTime dateThruAt
        ) {
            if (dateThruAt == null) {
                this.parameters.put("date_thru_at", null);
                return this;
            }

            this.parameters.put(
                    "date_thru_at",
                    dateThruAt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                );
            return this;
        }
    }
}
