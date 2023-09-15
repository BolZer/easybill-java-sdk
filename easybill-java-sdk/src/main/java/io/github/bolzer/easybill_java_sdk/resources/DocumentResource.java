package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.enums.DocumentSendType;
import io.github.bolzer.easybill_java_sdk.enums.DocumentType;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.Document;
import io.github.bolzer.easybill_java_sdk.requests.DocumentListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.DocumentRequest;
import io.github.bolzer.easybill_java_sdk.requests.DocumentSendRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.nio.ByteBuffer;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

/** The document resource contains methods to interact with the Document Endpoint of the REST API*/
public final class DocumentResource {

    @NonNull
    public static final String RESOURCE_URL = "/documents";

    @NonNull
    private final HttpClient httpClient;

    public DocumentResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Fetches documents in form of a paginated response
     * @param documentListRequest exposes different filter options for the list response
     * @return A paginated response containing information for count of pages etc.
     * @throws EasybillRestException Base Exception to the SDK. EasybillRestClientException | EasybillRestServerException
     */
    public @NonNull PaginatedResponse<Document> fetchDocuments(
        DocumentListQueryRequest documentListRequest
    ) throws EasybillRestException {
        return this.httpClient.requestGetJson(
                RESOURCE_URL,
                documentListRequest,
                new TypeReference<>() {}
            );
    }

    /** Fetch a document explicit by its id */
    public @NonNull Document fetchDocument(@Positive long documentId)
        throws EasybillRestException {
        return this.httpClient.requestGetJson(
                RESOURCE_URL + "/" + documentId,
                new TypeReference<>() {}
            );
    }

    /**
     * Method to create a document
     * @param documentRequest The requests which constructs the document
     * @return Returns a document containing the parameters from the document request
     * @throws EasybillRestException Base Exception to the SDK. EasybillRestClientException | EasybillRestServerException
     */
    public @NonNull Document createDocument(
        @NonNull DocumentRequest documentRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPostJson(
                RESOURCE_URL,
                documentRequest,
                new TypeReference<>() {}
            );
    }

    /**
     * Method to update an already existing document.
     * @see io.github.bolzer.easybill_java_sdk.resources.DocumentResource#finalizeDocument To finalize a document ("draft=false" to "draft=true")
     * @param documentId the id of the document to be updated
     * @param documentUpdateRequest The requests which constructs an update payload for the document
     * @return Returns a document with updated values from the update request
     * @throws EasybillRestException Base Exception to the SDK. EasybillRestClientException | EasybillRestServerException
     */
    public @NonNull Document updateDocument(
        @Positive long documentId,
        @NonNull DocumentRequest documentUpdateRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPutJson(
                RESOURCE_URL + "/" + documentId,
                documentUpdateRequest,
                new TypeReference<>() {}
            );
    }

    /**
     * Method to finalize a document. This moves the document from state "draft=true" to "draft=false".
     * Recurring Documents can't use this method as a recurring document remains forever in draft and
     * only acts as proxy producing actual documents which may be finalized.
     * The Process of Finalization will assign the document a number (if not already set on the document).
     * This number will be unique for the easybill account. A seconds document can't take the same number.
     *
     * @param documentId the id of the document to be updated/finalized
     * @param documentUpdateRequest Payload to update the document. This may be supplied along the request to finalize the document
     * @return Return the finalized / updated document
     * @throws EasybillRestException Base Exception to the SDK. EasybillRestClientException | EasybillRestServerException
     */
    public @NonNull Document finalizeDocument(
        @Positive long documentId,
        @NonNull DocumentRequest documentUpdateRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPutJson(
                RESOURCE_URL + "/" + documentId + "/done",
                documentUpdateRequest,
                new TypeReference<>() {}
            );
    }

    /**
     * Method to copy a document to the same type or a different type. Be aware that you can't copy any document to any
     * different document type. There are some rules at play which permit what is possible. As an example: An Invoice
     * may be copied to REMINDER or DUNNING, but may not be copied to PDF.
     *
     * If the operation is not permitted, an EasybillBadRequestException will be thrown indicating the aforementioned ruleset.
     *
     * @param documentId the id of the existing document to be copied
     * @param targetType the document type of the to be created document
     * @param documentUpdateRequest Payload to update/change
     * @return the copy of the existing document identified by the provided documentId with the targetType as type
     * @throws EasybillRestException Base Exception to the SDK. EasybillRestClientException | EasybillRestServerException
     */
    public @NonNull Document copyDocument(
        @Positive long documentId,
        @NonNull DocumentType targetType,
        @NonNull DocumentRequest documentUpdateRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPostJson(
                RESOURCE_URL + "/" + documentId + "/" + targetType,
                documentUpdateRequest,
                new TypeReference<>() {}
            );
    }

    /**
     * Method to delete an existing document
     * @param documentId the id of the existing document which is going to be deleted
     * @throws EasybillRestException Base Exception to the SDK. EasybillRestClientException | EasybillRestServerException
     */
    public void deleteDocument(@Positive long documentId)
        throws EasybillRestException {
        this.httpClient.requestDelete(RESOURCE_URL + "/" + documentId);
    }

    /**
     * Method to cancel an existing document. Cancelling an existing document entails the creation of a new document
     * with the type STORNO (Reversal).
     * @param documentId the id of the existing document which is going to be canceled
     * @throws EasybillRestException Base Exception to the SDK. EasybillRestClientException | EasybillRestServerException
     */
    public void cancelDocument(@Positive long documentId)
        throws EasybillRestException {
        this.httpClient.requestPostEmpty(
                RESOURCE_URL + "/" + documentId + "/cancel"
            );
    }

    /**
     * Method to send an existing document via EMAIL, FAX or MAIL. Be aware that the send types FAX and POST (MAIL) entail an easybill fee of usage.

     * @param documentId the id of the existing document which to be sent
     * @param documentSendType the method of how the document will be sent
     * @param documentSendRequest details for the send method. Like recipient etc. Fields like postSendType are only relevant for documentSentType POST
     * @throws EasybillRestException Base Exception to the SDK. EasybillRestClientException | EasybillRestServerException
     */
    public void sendDocument(
        @Positive long documentId,
        @NonNull DocumentSendType documentSendType,
        @NonNull DocumentSendRequest documentSendRequest
    ) throws EasybillRestException {
        this.httpClient.requestPostJson(
                RESOURCE_URL +
                "/" +
                documentId +
                "/send/" +
                documentSendType.toString().toLowerCase(),
                documentSendRequest
            );
    }

    /**
     * Method to download an existing document as a PDF document
     * @param documentId the id of the existing document which will be downloaded
     * @return ByteBuffer containing the actual binary content of the PDF document. NIO Files to write ByteBuffer to file.
     * @throws EasybillRestException Base Exception to the SDK. EasybillRestClientException | EasybillRestServerException
     */
    public @NonNull ByteBuffer downloadDocumentAsPdf(@Positive long documentId)
        throws EasybillRestException {
        return this.httpClient.requestGetBytes(
                RESOURCE_URL + "/" + documentId + "/pdf"
            );
    }

    /**
     * Method to download an existing document as a jpg
     * @param documentId the id of the existing document which will be downloaded
     * @return ByteBuffer containing the actual binary content of the PDF document. NIO Files to write ByteBuffer to file.
     * @throws EasybillRestException Base Exception to the SDK. EasybillRestClientException | EasybillRestServerException
     */
    public @NonNull ByteBuffer downloadDocumentAsJpg(@Positive long documentId)
        throws EasybillRestException {
        return this.httpClient.requestGetBytes(
                RESOURCE_URL + "/" + documentId + "/jpg"
            );
    }
}
