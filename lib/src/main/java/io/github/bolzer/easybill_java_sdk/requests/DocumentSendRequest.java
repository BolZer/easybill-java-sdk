package io.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bolzer.easybill_java_sdk.enums.DocumentFileType;
import io.github.bolzer.easybill_java_sdk.enums.PostSendType;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

@Builder
@Getter
public final class DocumentSendRequest {

    @Builder.Default
    @NonNull
    private String to = "";

    @Builder.Default
    @NonNull
    private String cc = "";

    @Builder.Default
    @NonNull
    private String from = "";

    @Builder.Default
    @NonNull
    private String subject = "";

    @Builder.Default
    @NonNull
    private String message = "";

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Nullable
    @Builder.Default
    private LocalDate date = null;

    @JsonProperty("send_by_self")
    @Builder.Default
    private boolean sendBySelf = false;

    @JsonProperty("send_with_attachment")
    @Builder.Default
    private boolean sendWithAttachment = true;

    @JsonProperty("document_file_type")
    @Builder.Default
    @NonNull
    private DocumentFileType documentFileType = DocumentFileType.DEFAULT;

    @JsonProperty("post_send_type")
    @Builder.Default
    @Nullable
    private PostSendType postSendType = null;
}
