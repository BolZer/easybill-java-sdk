package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.TextTemplate;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.TextTemplateRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class TextTemplateResource {

    @NonNull
    public static final String RESOURCE_URL = "/text-templates";

    @NonNull
    private final HttpClient httpClient;

    public TextTemplateResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<TextTemplate> fetchTextTemplates(
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.requestGetJson(
                RESOURCE_URL,
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull TextTemplate fetchTextTemplate(
        @Positive long textTemplateId
    ) throws EasybillRestException {
        return this.httpClient.requestGetJson(
                RESOURCE_URL + "/" + textTemplateId,
                new TypeReference<>() {}
            );
    }

    public @NonNull TextTemplate createTextTemplate(
        @NonNull TextTemplateRequest textTemplateRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPostJson(
                RESOURCE_URL,
                textTemplateRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull TextTemplate updateTextTemplate(
        @Positive long textTemplateId,
        @NonNull TextTemplateRequest textTemplateRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPutJson(
                RESOURCE_URL + "/" + textTemplateId,
                textTemplateRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteTextTemplate(@Positive long textTemplateId)
        throws EasybillRestException {
        this.httpClient.requestDelete(RESOURCE_URL + "/" + textTemplateId);
    }
}
