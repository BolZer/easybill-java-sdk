package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.enums.DocumentSendType;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.Document;
import io.github.bolzer.easybill_java_sdk.requests.DocumentListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.DocumentRequest;
import io.github.bolzer.easybill_java_sdk.requests.DocumentSendRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class DocumentResource {

    @NonNull
    public static final String RESOURCE_URL = "/documents";

    @NonNull
    private final HttpClient httpClient;

    public DocumentResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<Document> fetchDocuments(
        DocumentListQueryRequest documentListRequest
    ) throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL,
                documentListRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Document fetchDocument(@Positive long documentId)
        throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/" + documentId,
                new TypeReference<>() {}
            );
    }

    public @NonNull Document createDocument(
        @NonNull DocumentRequest documentRequest
    ) throws EasybillRestException {
        return this.httpClient.postJson(
                RESOURCE_URL,
                documentRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Document updateDocument(
        @Positive long documentId,
        @NonNull DocumentRequest documentUpdateRequest
    ) throws EasybillRestException {
        return this.httpClient.putJson(
                RESOURCE_URL + "/" + documentId,
                documentUpdateRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Document finalizeDocument(
        @Positive long documentId,
        @NonNull DocumentRequest documentUpdateRequest
    ) throws EasybillRestException {
        return this.httpClient.putJson(
                RESOURCE_URL + "/" + documentId + "/done",
                documentUpdateRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteDocument(@Positive long documentId)
        throws EasybillRestException {
        this.httpClient.delete(RESOURCE_URL + "/" + documentId);
    }

    public void cancelDocument(@Positive long documentId)
        throws EasybillRestException {
        this.httpClient.postEmpty(RESOURCE_URL + "/" + documentId + "/cancel");
    }

    public void sendDocument(
        @Positive long documentId,
        @NonNull DocumentSendType documentSendType,
        @NonNull DocumentSendRequest documentSendRequest
    ) throws EasybillRestException {
        this.httpClient.postJson(
                RESOURCE_URL +
                "/" +
                documentId +
                "/send/" +
                documentSendType.toString().toLowerCase(),
                documentSendRequest
            );
    }

    public byte[] downloadDocumentAsPdf(@Positive long documentId)
        throws EasybillRestException {
        return this.httpClient.getBytes(
                RESOURCE_URL + "/" + documentId + "/pdf"
            );
    }

    public byte[] downloadDocumentAsJpg(@Positive long documentId)
        throws EasybillRestException {
        return this.httpClient.getBytes(
                RESOURCE_URL + "/" + documentId + "/jpg"
            );
    }
}
