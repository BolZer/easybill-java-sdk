package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.*;
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
    public void testCreateCustomerFailBadRequest()
        throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerCreateFailFixture())
        );

        try {
            client
                .getCustomerResource()
                .createCustomer(CustomerRequest.builder().build());
        } catch (EasybillBadRequestException exception) {
            assertThat(exception.getResponseStatusCode()).isEqualTo(400);
            assertThat(exception.getInternalErrorCode()).isEqualTo(20000);
            assertThat(exception.getArguments()).contains("last_name");
            assertThat(exception.getArguments()).contains("company_name");
            assertThat(exception.getMessage())
                .contains("Bitte füllen Sie alle Felder aus.");
        }
    }

    @Test
    public void testCreateCustomerFailServerException()
        throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerCreateFailServerExceptionFixture())
        );

        try {
            client
                .getCustomerResource()
                .createCustomer(CustomerRequest.builder().build());
        } catch (EasybillRestServerException exception) {
            assertThat(exception.getResponseStatusCode()).isEqualTo(503);
            assertThat(exception.getMessage())
                .contains("received status code: 503");
        }
    }

    @Test
    public void testCreateCustomerFailTooManyRequestsException()
        throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerCreateFailTooManyRequestsExceptionFixture())
        );

        try {
            client
                .getCustomerResource()
                .createCustomer(CustomerRequest.builder().build());
        } catch (EasybillTooManyRequestsException exception) {
            assertThat(exception.getResponseStatusCode()).isEqualTo(429);
            assertThat(exception.getRetryAfterInSeconds()).isEqualTo(60);
            assertThat(exception.getMessage())
                .contains("request limit exceeded");
        }
    }

    @Test
    public void testCreateCustomerFailRequestUrlTooLongException()
        throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new CustomerCreateFailRequestUrlTooLongExceptionFixture())
        );

        try {
            client
                .getCustomerResource()
                .createCustomer(CustomerRequest.builder().build());
        } catch (EasybillRequestUrlTooLongException exception) {
            assertThat(exception.getResponseStatusCode()).isEqualTo(414);
            assertThat(exception.getMessage())
                .contains("request url is too long");
            assertThat(exception.getRequest().url().toString())
                .contains("/rest/v1/customers");
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
