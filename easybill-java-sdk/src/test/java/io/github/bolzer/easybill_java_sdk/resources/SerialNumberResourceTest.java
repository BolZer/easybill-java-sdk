package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.serial_numbers.SerialNumberCreateFixture;
import io.github.bolzer.easybill_java_sdk.fixtures.serial_numbers.SerialNumberDeleteFixture;
import io.github.bolzer.easybill_java_sdk.fixtures.serial_numbers.SerialNumberFetchFixture;
import io.github.bolzer.easybill_java_sdk.fixtures.serial_numbers.SerialNumberFetchListWithQueryFixture;
import io.github.bolzer.easybill_java_sdk.models.SerialNumber;
import io.github.bolzer.easybill_java_sdk.requests.SerialNumberListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.SerialNumberRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class SerialNumberResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchSerialNumbers() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new SerialNumberFetchListWithQueryFixture())
        );

        final PaginatedResponse<SerialNumber> response = client
            .getSerialNumberResource()
            .fetchSerialNumbers(
                SerialNumberListQueryRequest.builder().limit(1).page(2).build()
            );

        assertThat(response.page()).isEqualTo(2);
        assertThat(response.pages()).isEqualTo(29);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(29);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchSerialNumber() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new SerialNumberFetchFixture())
        );

        final SerialNumber response = client
            .getSerialNumberResource()
            .fetchSerialNumber(2L);

        assertThat(response.id()).isEqualTo(2L);
    }

    @Test
    public void testCreateSerialNumber() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new SerialNumberCreateFixture())
        );

        final SerialNumber response = client
            .getSerialNumberResource()
            .createSerialNumber(
                SerialNumberRequest
                    .builder()
                    .serialNumber("00010")
                    .positionId(2L)
                    .build()
            );

        assertThat(response.serialNumber()).isEqualTo("00010");
        assertThat(response.positionId()).isEqualTo(2L);
    }

    @Test
    public void testDeleteSerialNumber() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new SerialNumberDeleteFixture())
        );

        client.getSerialNumberResource().deleteSerialNumber(30L);
    }
}
