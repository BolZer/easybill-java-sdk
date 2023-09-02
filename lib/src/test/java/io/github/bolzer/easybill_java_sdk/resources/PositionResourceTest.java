package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.positions.*;
import io.github.bolzer.easybill_java_sdk.models.Position;
import io.github.bolzer.easybill_java_sdk.requests.PositionListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.PositionRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class PositionResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchPositions() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionFetchListWithQueryFixture())
        );

        final PaginatedResponse<Position> response = client
            .getPositionResource()
            .fetchPositions(
                PositionListQueryRequest.builder().limit(1).page(2).build()
            );

        assertThat(response.page()).isEqualTo(2);
        assertThat(response.pages()).isEqualTo(42);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(42);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchPosition() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionFetchFixture())
        );

        final Position response = client
            .getPositionResource()
            .fetchPosition(2L);

        assertThat(response.id()).isEqualTo(2L);
    }

    @Test
    public void testCreatePosition() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionCreateFixture())
        );

        final Position response = client
            .getPositionResource()
            .createPosition(
                PositionRequest
                    .builder()
                    .number("something")
                    .description("something else")
                    .salePrice(1000L)
                    .build()
            );

        assertThat(response.number()).isEqualTo("something");
        assertThat(response.description()).isEqualTo("something else");
        assertThat(response.salePrice()).isEqualTo(1000L);
    }

    @Test
    public void testUpdatePosition() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionUpdateFixture())
        );

        final Position response = client
            .getPositionResource()
            .updatePosition(
                43L,
                PositionRequest
                    .builder()
                    .number("changed something")
                    .description("changed something else")
                    .salePrice(2000L)
                    .build()
            );

        assertThat(response.id()).isEqualTo(43L);
        assertThat(response.number()).isEqualTo("changed something");
        assertThat(response.description()).isEqualTo("changed something else");
        assertThat(response.salePrice()).isEqualTo(2000L);
    }

    @Test
    public void testDeletePosition() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionDeleteFixture())
        );

        client.getPositionResource().deletePosition(43L);
    }
}
