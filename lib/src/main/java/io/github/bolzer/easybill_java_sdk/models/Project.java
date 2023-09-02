package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bolzer.easybill_java_sdk.enums.BudgetNotifyFrequency;
import io.github.bolzer.easybill_java_sdk.enums.ProjectStatus;
import java.time.LocalDate;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record Project(
    @JsonProperty("id") long id,
    @JsonProperty("budget_amount") long budgetAmount,

    @JsonProperty("budget_notify_frequency")
    @NonNull
    BudgetNotifyFrequency budgetNotifyFrequency,
    @JsonProperty("budget_time") long budgetTime,
    @JsonProperty("consumed_amount") long consumedAmount,
    @JsonProperty("consumed_time") long consumedTime,
    @JsonProperty("customer_id") @Nullable Long customerId,
    @JsonProperty("due_at")
    @Nullable
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dueAt,

    @JsonProperty("hourly_rate") long hourlyRate,
    @JsonProperty("login_id") long loginId,

    @JsonProperty("name") @NonNull String name,
    @JsonProperty("note") @NonNull String note,
    @JsonProperty("status") @NonNull ProjectStatus status
) {}
