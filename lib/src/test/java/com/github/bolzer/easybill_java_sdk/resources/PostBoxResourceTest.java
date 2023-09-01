package com.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.bolzer.easybill_java_sdk.Client;
import com.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import com.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import com.github.bolzer.easybill_java_sdk.fixtures.customer_groups.*;
import com.github.bolzer.easybill_java_sdk.fixtures.post_boxes.PostBoxDeleteFixture;
import com.github.bolzer.easybill_java_sdk.fixtures.post_boxes.PostBoxFetchFixture;
import com.github.bolzer.easybill_java_sdk.fixtures.post_boxes.PostBoxFetchListWithQueryFixture;
import com.github.bolzer.easybill_java_sdk.models.PostBox;
import com.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import com.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class PostBoxResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchPostBoxes() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PostBoxFetchListWithQueryFixture())
        );

        final PaginatedResponse<PostBox> response = client
            .getPostBoxResource()
            .fetchPostBoxes(
                GenericListQueryRequest.builder().limit(1).page(1).build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(14);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(14);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchPostBox() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PostBoxFetchFixture())
        );

        final PostBox response = client.getPostBoxResource().fetchPostBox(1L);

        assertThat(response.id()).isEqualTo(1L);
    }

    @Test
    public void testDeletePostBox() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PostBoxDeleteFixture())
        );

        client.getPostBoxResource().deletePostBox(1L);
    }
}
