package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bolzer.easybill_java_sdk.enums.DocumentFileType;
import io.github.bolzer.easybill_java_sdk.enums.PostBoxPostSendType;
import io.github.bolzer.easybill_java_sdk.enums.PostBoxStatus;
import io.github.bolzer.easybill_java_sdk.enums.PostBoxType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record PostBox(
    @JsonProperty("id") long id,

    @JsonProperty("document_id") long documentId,

    @JsonProperty("to") @Nullable String to,

    @JsonProperty("cc") @Nullable String cc,

    @JsonProperty("from") @Nullable String from,

    @JsonProperty("subject") @Nullable String subject,

    @JsonProperty("message") @Nullable String message,

    @JsonProperty("date")
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date,

    @JsonProperty("created_at")
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdAt,

    @JsonProperty("processed_at")
    @Nullable
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime processedAt,

    @JsonProperty("send_by_self") boolean sendBySelf,

    @JsonProperty("send_with_attachment") boolean sendWithAttachment,

    @JsonProperty("type") @NonNull PostBoxType type,

    @JsonProperty("status") @NonNull PostBoxStatus status,

    @JsonProperty("status_msg") @Nullable String statusMsg,

    @JsonProperty("login_id") long loginId,

    @JsonProperty("document_file_type")
    @Nullable
    DocumentFileType documentFileType,

    @JsonProperty("post_send_type") @Nullable PostBoxPostSendType postSendType,

    @JsonProperty("tracking_identifier") @Nullable String trackingIdentifier
) {}
