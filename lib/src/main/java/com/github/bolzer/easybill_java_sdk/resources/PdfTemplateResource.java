package com.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.models.PdfTemplate;
import com.github.bolzer.easybill_java_sdk.requests.PdfTemplateRequest;
import com.github.bolzer.easybill_java_sdk.responses.NonPaginatedResponse;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class PdfTemplateResource {

    @NonNull
    public static final String RESOURCE_URL = "/pdf-templates";

    @NonNull
    private final HttpClient httpClient;

    public PdfTemplateResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull NonPaginatedResponse<PdfTemplate> fetchPdfTemplates()
        throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                null,
                new TypeReference<>() {}
            );
    }

    public @NonNull NonPaginatedResponse<PdfTemplate> fetchPdfTemplates(
        PdfTemplateRequest pdfTemplateRequest
    ) throws EasybillRestException {
        return this.httpClient.doGetRequestAndMarshalJsonInto(
                RESOURCE_URL,
                pdfTemplateRequest,
                new TypeReference<>() {}
            );
    }
}
