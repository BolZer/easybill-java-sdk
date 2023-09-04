package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.customer_groups.*;
import io.github.bolzer.easybill_java_sdk.models.CustomerGroup;
import io.github.bolzer.easybill_java_sdk.requests.CustomerGroupRequest;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class CustomerGroupResourceTest
    extends EasybillRestClientTestcase {

    @Test
    public void testFetchCustomerGroups() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerGroupFetchListWithQueryFixture())
        );

        final PaginatedResponse<CustomerGroup> response = client
            .getCustomerGroupResource()
            .fetchCustomerGroups(
                GenericListQueryRequest.builder().limit(1).page(2).build()
            );

        assertThat(response.page()).isEqualTo(2);
        assertThat(response.pages()).isEqualTo(11);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(11);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchCustomerGroup() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerGroupFetchFixture())
        );

        final CustomerGroup response = client
            .getCustomerGroupResource()
            .fetchCustomerGroup(2L);

        assertThat(response.id()).isEqualTo(2L);
    }

    @Test
    public void testCreateCustomerGroup() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerGroupCreateFixture())
        );

        final CustomerGroup response = client
            .getCustomerGroupResource()
            .createCustomerGroup(
                CustomerGroupRequest
                    .builder()
                    .number("00010")
                    .description("A test customer group")
                    .name("Customer Group")
                    .build()
            );

        assertThat(response.number()).isEqualTo("00010");
        assertThat(response.description()).isEqualTo("A test customer group");
    }

    @Test
    public void testUpdateCustomerGroup() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerGroupUpdateFixture())
        );

        final CustomerGroup response = client
            .getCustomerGroupResource()
            .updateCustomerGroup(
                12L,
                CustomerGroupRequest
                    .builder()
                    .number("00011")
                    .description("Changed A test customer group")
                    .name("Changed Customer Group")
                    .build()
            );

        assertThat(response.id()).isEqualTo(12L);
        assertThat(response.number()).isEqualTo("00011");
        assertThat(response.description())
            .isEqualTo("Changed A test customer group");
    }

    @Test
    public void testDeleteCustomerGroup() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerGroupDeleteFixture())
        );

        client.getCustomerGroupResource().deleteCustomerGroup(12L);
    }
}
