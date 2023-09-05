package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.contacts.*;
import io.github.bolzer.easybill_java_sdk.models.Contact;
import io.github.bolzer.easybill_java_sdk.requests.ContactRequest;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class ContactResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchContacts() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new ContactFetchListWithQueryFixture())
        );

        final PaginatedResponse<Contact> response = client
            .getContactResource()
            .fetchContacts(
                6L,
                GenericListQueryRequest.builder().limit(1).page(1).build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(3);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(3);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchContact() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new ContactFetchFixture())
        );

        final Contact response = client
            .getContactResource()
            .fetchContact(6L, 1L);

        assertThat(response.id()).isEqualTo(1L);
    }

    @Test
    public void testCreateContact() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new ContactCreateFixture())
        );

        final Contact response = client
            .getContactResource()
            .createContact(
                6L,
                ContactRequest
                    .builder()
                    .street("Test")
                    .city("Test")
                    .lastName("Something")
                    .firstName("Else")
                    .companyName("Else Company")
                    .country("DE")
                    .mobile("+4917280428")
                    .emails(List.of("test@test.de"))
                    .department("Something")
                    .build()
            );

        assertThat(response.street()).isEqualTo("Test");
        assertThat(response.city()).isEqualTo("Test");
        assertThat(response.lastName()).isEqualTo("Something");
        assertThat(response.firstName()).isEqualTo("Else");
        assertThat(response.companyName()).isEqualTo("Else Company");
        assertThat(response.country()).isEqualTo("DE");
        assertThat(response.mobile()).isEqualTo("+4917280428");
        assertThat(response.emails()).contains("test@test.de");
        assertThat(response.department()).isEqualTo("Something");
    }

    @Test
    public void testUpdateContact() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new ContactUpdateFixture())
        );

        final Contact response = client
            .getContactResource()
            .updateContact(
                6L,
                8L,
                ContactRequest.builder().lastName("Something Else").build()
            );

        assertThat(response.id()).isEqualTo(8L);
        assertThat(response.lastName()).isEqualTo("Something Else");
    }

    @Test
    public void testDeleteContact() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new ContactDeleteFixture())
        );

        client.getContactResource().deleteContact(6L, 8L);
    }
}
