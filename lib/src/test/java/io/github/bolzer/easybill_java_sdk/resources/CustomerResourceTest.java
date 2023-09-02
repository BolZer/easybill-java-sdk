package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillBadRequestException;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.customers.*;
import io.github.bolzer.easybill_java_sdk.models.Customer;
import io.github.bolzer.easybill_java_sdk.requests.CustomerListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.CustomerRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class CustomerResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchCustomers() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerFetchListWithQueryFixture())
        );

        final PaginatedResponse<Customer> response = client
            .getCustomerResource()
            .fetchCustomers(
                CustomerListQueryRequest.builder().limit(1).page(1).build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(19);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(19);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchCustomer() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerFetchFixture())
        );

        final Customer response = client
            .getCustomerResource()
            .fetchCustomer(14L);

        assertThat(response.id()).isEqualTo(14L);
    }

    @Test
    public void testCreateCustomer() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerCreateFixture())
        );

        final Customer response = client
            .getCustomerResource()
            .createCustomer(
                CustomerRequest.builder().lastName("something").build()
            );

        assertThat(response.lastName()).isEqualTo("something");
    }

    @Test
    public void testCreateCustomerFail() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerCreateFailFixture())
        );

        try {
            client
                .getCustomerResource()
                .createCustomer(CustomerRequest.builder().build());
        } catch (EasybillBadRequestException exception) {
            assertThat(exception.getInternalErrorCode()).isEqualTo(20000);
            assertThat(exception.getArguments()).contains("last_name");
            assertThat(exception.getArguments()).contains("company_name");
            assertThat(exception.getMessage())
                .contains("Bitte füllen Sie alle Felder aus.");
        }
    }

    @Test
    public void testUpdateCustomer() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerUpdateFixture())
        );

        final Customer response = client
            .getCustomerResource()
            .updateCustomer(
                23L,
                CustomerRequest.builder().lastName("something_else").build()
            );

        assertThat(response.id()).isEqualTo(23L);
        assertThat(response.lastName()).isEqualTo("something_else");
    }

    @Test
    public void testDeleteCustomer() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerDeleteFixture())
        );

        client.getCustomerResource().deleteCustomer(23L);
    }
}
