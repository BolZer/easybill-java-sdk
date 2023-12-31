package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.Attachment;
import io.github.bolzer.easybill_java_sdk.requests.AttachmentRequest;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.io.File;
import java.nio.ByteBuffer;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class AttachmentResource {

    @NonNull
    public static final String RESOURCE_URL = "/attachments";

    @NonNull
    private final HttpClient httpClient;

    public AttachmentResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<Attachment> fetchAttachments(
        GenericListQueryRequest genericListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.requestGetJson(
                RESOURCE_URL,
                genericListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Attachment fetchAttachment(long attachmentId)
        throws EasybillRestException {
        return this.httpClient.requestGetJson(
                RESOURCE_URL + "/" + attachmentId,
                new TypeReference<>() {}
            );
    }

    public @NonNull Attachment createAttachment(File file)
        throws EasybillRestException {
        return this.httpClient.requestPostFile(
                RESOURCE_URL,
                file,
                new TypeReference<>() {}
            );
    }

    public @NonNull Attachment updateAttachment(
        @Positive long attachmentId,
        @NonNull AttachmentRequest attachmentRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPutJson(
                RESOURCE_URL + "/" + attachmentId,
                attachmentRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull ByteBuffer fetchAttachmentContent(long attachmentId)
        throws EasybillRestException {
        return this.httpClient.requestGetBytes(
                RESOURCE_URL + "/" + attachmentId + "/content"
            );
    }

    public void deleteAttachment(@Positive long attachmentId)
        throws EasybillRestException {
        this.httpClient.requestDelete(RESOURCE_URL + "/" + attachmentId);
    }
}
