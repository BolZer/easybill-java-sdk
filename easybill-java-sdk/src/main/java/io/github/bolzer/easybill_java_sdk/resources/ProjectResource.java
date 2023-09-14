package io.github.bolzer.easybill_java_sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.models.Project;
import io.github.bolzer.easybill_java_sdk.requests.ProjectListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.ProjectRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class ProjectResource {

    @NonNull
    public static final String RESOURCE_URL = "/projects";

    @NonNull
    private final HttpClient httpClient;

    public ProjectResource(@NonNull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public @NonNull PaginatedResponse<Project> fetchProjects(
        ProjectListQueryRequest projectListQueryRequest
    ) throws EasybillRestException {
        return this.httpClient.requestGetJson(
                RESOURCE_URL,
                projectListQueryRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Project fetchProject(@Positive long projectId)
        throws EasybillRestException {
        return this.httpClient.requestGetJson(
                RESOURCE_URL + "/" + projectId,
                new TypeReference<>() {}
            );
    }

    public @NonNull Project createProject(
        @NonNull ProjectRequest projectRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPostJson(
                RESOURCE_URL,
                projectRequest,
                new TypeReference<>() {}
            );
    }

    public @NonNull Project updateProject(
        @Positive long projectId,
        @NonNull ProjectRequest projectRequest
    ) throws EasybillRestException {
        return this.httpClient.requestPutJson(
                RESOURCE_URL + "/" + projectId,
                projectRequest,
                new TypeReference<>() {}
            );
    }

    public void deleteProject(@Positive long projectId)
        throws EasybillRestException {
        this.httpClient.requestDelete(RESOURCE_URL + "/" + projectId);
    }
}
