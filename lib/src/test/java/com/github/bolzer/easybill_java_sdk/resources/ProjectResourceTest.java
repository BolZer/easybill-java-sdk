package com.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.bolzer.easybill_java_sdk.Client;
import com.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import com.github.bolzer.easybill_java_sdk.enums.ProjectStatus;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.fixtures.customer_groups.*;
import com.github.bolzer.easybill_java_sdk.fixtures.projects.*;
import com.github.bolzer.easybill_java_sdk.models.Project;
import com.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.ProjectRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class ProjectResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchProjects() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new ProjectFetchListWithQueryFixture())
        );

        final PaginatedResponse<Project> response = client
            .getProjectResource()
            .fetchProjects(
                GenericListQueryRequest.builder().limit(1).page(1).build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(33);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(33);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchProject() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new ProjectFetchFixture())
        );

        final Project response = client
            .getProjectResource()
            .fetchProject(88453L);

        assertThat(response.id()).isEqualTo(88453L);
    }

    @Test
    public void testCreateProject() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new ProjectCreateFixture())
        );

        final Project response = client
            .getProjectResource()
            .createProject(
                ProjectRequest
                    .builder()
                    .name("Test")
                    .note("Test Note")
                    .status(ProjectStatus.CANCEL)
                    .build()
            );

        assertThat(response.id()).isEqualTo(431568L);
        assertThat(response.name()).isEqualTo("Test");
        assertThat(response.note()).isEqualTo("Test Note");
        assertThat(response.status()).isEqualTo(ProjectStatus.CANCEL);
    }

    @Test
    public void testUpdateProject() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new ProjectUpdateFixture())
        );

        final Project response = client
            .getProjectResource()
            .updateProject(
                431568L,
                ProjectRequest.builder().status(ProjectStatus.DONE).build()
            );

        assertThat(response.id()).isEqualTo(431568L);
        assertThat(response.name()).isEqualTo("Test");
        assertThat(response.note()).isEqualTo("Test Note");
        assertThat(response.status()).isEqualTo(ProjectStatus.DONE);
    }

    @Test
    public void testDeleteProject() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new ProjectDeleteFixture())
        );

        client.getProjectResource().deleteProject(431568L);
    }
}
