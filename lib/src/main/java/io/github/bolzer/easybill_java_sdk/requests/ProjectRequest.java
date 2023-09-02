package io.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.bolzer.easybill_java_sdk.enums.BudgetNotifyFrequency;
import io.github.bolzer.easybill_java_sdk.enums.ProjectStatus;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class ProjectRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private ProjectRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static ProjectRequestBuilder builder() {
        return new ProjectRequestBuilder();
    }

    public static class ProjectRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public ProjectRequest build() {
            return new ProjectRequest(this.parameters);
        }

        public ProjectRequestBuilder name(@NonNull String name) {
            this.parameters.put("name", name);
            return this;
        }

        public ProjectRequestBuilder note(@NonNull String note) {
            this.parameters.put("note", note);
            return this;
        }

        public ProjectRequestBuilder status(@NonNull ProjectStatus status) {
            this.parameters.put("status", status.toString());
            return this;
        }

        public ProjectRequestBuilder customerId(@Nullable Long customerId) {
            if (customerId == null) {
                this.parameters.put("customer_id", null);
                return this;
            }

            this.parameters.put("customer_id", customerId);
            return this;
        }

        public ProjectRequestBuilder budgetAmount(long budgetAmount) {
            this.parameters.put("budget_amount", budgetAmount);
            return this;
        }

        public ProjectRequestBuilder budgetNotifyFrequency(
            @NonNull BudgetNotifyFrequency budgetNotifyFrequency
        ) {
            this.parameters.put(
                    "budget_notify_frequency",
                    budgetNotifyFrequency.toString()
                );
            return this;
        }

        public ProjectRequestBuilder budgetTime(long budgetTime) {
            this.parameters.put("budget_time", budgetTime);
            return this;
        }

        public ProjectRequestBuilder consumedAmount(long consumedAmount) {
            this.parameters.put("consumed_amount", consumedAmount);
            return this;
        }

        public ProjectRequestBuilder consumedTime(long consumedTime) {
            this.parameters.put("consumed_time", consumedTime);
            return this;
        }

        public ProjectRequestBuilder hourlyRate(long hourlyRate) {
            this.parameters.put("hourly_rate", hourlyRate);
            return this;
        }

        public ProjectRequestBuilder dueAt(@Nullable LocalDate dueAt) {
            if (dueAt == null) {
                this.parameters.put("due_at", null);
                return this;
            }

            this.parameters.put(
                    "due_at",
                    dueAt.format(DateTimeFormatter.ISO_DATE)
                );
            return this;
        }
    }
}
