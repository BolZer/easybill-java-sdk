package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.time_trackings.*;
import io.github.bolzer.easybill_java_sdk.models.TimeTracking;
import io.github.bolzer.easybill_java_sdk.requests.TimeTrackingListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.TimeTrackingRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

public final class TimeTrackingResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchTimeTrackings() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new TimeTrackingFetchListWithQueryFixture())
        );

        final PaginatedResponse<TimeTracking> response = client
            .getTimeTrackingResource()
            .fetchTimeTrackings(
                TimeTrackingListQueryRequest
                    .builder()
                    .limit(1)
                    .page(1)
                    .dateThruAt(LocalDate.parse("2020-01-01"))
                    .dateFromBetween(
                        new Pair<>(
                            LocalDate.parse("2020-01-31"),
                            LocalDate.parse("2025-04-01")
                        )
                    )
                    .build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(31);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(31);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchTimeTracking() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new TImeTrackingFetchFixture())
        );

        final TimeTracking response = client
            .getTimeTrackingResource()
            .fetchTimeTracking(36L);

        assertThat(response.id()).isEqualTo(36L);
        assertThat(response.number()).isEqualTo("1337-11");
        assertThat(response.description())
            .contains("Arbeiten von Morgens bis Abends");
        assertThat(response.clearedAt().format(DateTimeFormatter.ISO_DATE_TIME))
            .isEqualTo("2023-08-30T10:34:24");
    }

    @Test
    public void testCreateTimeTracking() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new TimeTrackingCreateFixture())
        );

        final TimeTracking response = client
            .getTimeTrackingResource()
            .createTimeTracking(
                TimeTrackingRequest
                    .builder()
                    .description("Test")
                    .positionId(1L)
                    .clearedAt(LocalDateTime.parse("2020-01-01T01:01:01"))
                    .note("Test Note")
                    .number("Test")
                    .dateFromAt(LocalDateTime.parse("2020-03-03T23:23:23"))
                    .build()
            );

        assertThat(response.number()).isEqualTo("Test");
        assertThat(response.description()).isEqualTo("Test");
        assertThat(response.positionId()).isEqualTo(1L);
    }

    @Test
    public void testUpdateTimeTracking() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new TimeTrackingUpdateFixture())
        );

        final TimeTracking response = client
            .getTimeTrackingResource()
            .updateTimeTracking(
                55L,
                TimeTrackingRequest.builder().number("Test 00001").build()
            );

        assertThat(response.id()).isEqualTo(55L);
        assertThat(response.number()).isEqualTo("Test 00001");
        assertThat(response.description()).isEqualTo("Test");
    }

    @Test
    public void testDeleteTimeTracking() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new TimeTrackingDeleteFixture())
        );

        client.getTimeTrackingResource().deleteTimeTracking(55L);
    }
}
