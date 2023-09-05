package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.bolzer.easybill_java_sdk.enums.DocumentType;
import org.checkerframework.checker.nullness.qual.NonNull;

public record PdfTemplate(
    @JsonProperty("id") @NonNull String id,
    @JsonProperty("name") @NonNull String name,
    @JsonProperty("pdf_template") @NonNull String pdfTemplate,
    @JsonProperty("document_type") @NonNull DocumentType documentType,
    @JsonProperty("settings") @NonNull PdfTemplateSetting settings
) {
    public record PdfTemplateSetting(
        @JsonProperty("text_prefix") @NonNull String textPrefix,
        @JsonProperty("text") @NonNull String text,
        @JsonProperty("email") @NonNull PdfTemplateEmailSetting email
    ) {}

    public record PdfTemplateEmailSetting(
        @JsonProperty("subject") @NonNull String subject,
        @JsonProperty("message") @NonNull String message
    ) {}
}
