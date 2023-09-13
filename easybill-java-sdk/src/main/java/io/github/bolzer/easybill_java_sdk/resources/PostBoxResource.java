package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.PostBox;
import io.github.bolzer.easybill_java_sdk.requests.PostBoxListQueryRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class PostBoxResource {

    @NonNull
    public static final String RESOURCE_URL = "/post-boxes";

    @NonNull
    @SuppressFBWarnings
    private final HttpClient httpClient;

    public PostBoxResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<PostBox> fetchPostBoxes(
        PostBoxListQueryRequest postBoxListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL,
                postBoxListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull PostBox fetchPostBox(@Positive long postBoxId)
        throws EasybillRestException {
        return this.httpClient.getJson(
                RESOURCE_URL + "/" + postBoxId,
                new TypeReference<>() {}
            );
    }

    public void deletePostBox(@Positive long postBoxId)
        throws EasybillRestException {
        this.httpClient.delete(RESOURCE_URL + "/" + postBoxId);
    }
}
