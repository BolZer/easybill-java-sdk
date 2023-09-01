package com.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.bolzer.easybill_java_sdk.Client;
import com.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.fixtures.position_groups.*;
import com.github.bolzer.easybill_java_sdk.fixtures.positions.*;
import com.github.bolzer.easybill_java_sdk.models.PositionGroup;
import com.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import com.github.bolzer.easybill_java_sdk.requests.PositionGroupRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class PositionGroupResourceTest
    extends EasybillRestClientTestcase {

    @Test
    public void testFetchPositionGroups() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionGroupFetchListWithQueryFixture())
        );

        final PaginatedResponse<PositionGroup> response = client
            .getPositionGroupResource()
            .fetchPositionGroups(
                GenericListQueryRequest.builder().limit(1).page(2).build()
            );

        assertThat(response.page()).isEqualTo(2);
        assertThat(response.pages()).isEqualTo(3);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(3);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchPositionGroup() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionGroupFetchFixture())
        );

        final PositionGroup response = client
            .getPositionGroupResource()
            .fetchPositionGroup(2L);

        assertThat(response.id()).isEqualTo(2L);
    }

    @Test
    public void testCreatePositionGroup() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionGroupCreateFixture())
        );

        final PositionGroup response = client
            .getPositionGroupResource()
            .createPositionGroup(
                PositionGroupRequest
                    .builder()
                    .number("00010")
                    .description("A test position group")
                    .name("Position Group")
                    .build()
            );

        assertThat(response.number()).isEqualTo("00010");
        assertThat(response.description()).isEqualTo("A test position group");
    }

    @Test
    public void testUpdatePositionGroup() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionGroupUpdateFixture())
        );

        final PositionGroup response = client
            .getPositionGroupResource()
            .updatePositionGroup(
                4L,
                PositionGroupRequest
                    .builder()
                    .number("00011")
                    .description("changed position group")
                    .name("Changed Position Group")
                    .build()
            );

        assertThat(response.id()).isEqualTo(4L);
        assertThat(response.number()).isEqualTo("00011");
        assertThat(response.description()).isEqualTo("changed position group");
    }

    @Test
    public void testDeletePositionGroup() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionGroupDeleteFixture())
        );

        client.getPositionGroupResource().deletePositionGroup(4L);
    }
}
