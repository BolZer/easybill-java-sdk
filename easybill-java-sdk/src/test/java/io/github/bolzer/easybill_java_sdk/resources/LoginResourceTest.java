package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.logins.LoginFetchFixture;
import io.github.bolzer.easybill_java_sdk.fixtures.logins.LoginFetchListFixture;
import io.github.bolzer.easybill_java_sdk.models.Login;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class LoginResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchLogins() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new LoginFetchListFixture())
        );

        final PaginatedResponse<Login> response = client
            .getLoginResource()
            .fetchLogins(
                GenericListQueryRequest.builder().limit(1).page(1).build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(8);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(8);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchLogin() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new LoginFetchFixture())
        );

        final Login response = client.getLoginResource().fetchLogin(2L);

        assertThat(response.id()).isEqualTo(2L);
    }
}
