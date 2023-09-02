package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.enums.DiscountType;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.discounts.position.*;
import io.github.bolzer.easybill_java_sdk.fixtures.discounts.position_group.*;
import io.github.bolzer.easybill_java_sdk.models.PositionDiscount;
import io.github.bolzer.easybill_java_sdk.models.PositionGroupDiscount;
import io.github.bolzer.easybill_java_sdk.requests.GenericListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.PositionDiscountRequest;
import io.github.bolzer.easybill_java_sdk.requests.PositionGroupDiscountRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class DiscountResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchPositionDiscounts() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionDiscountFetchListWithQueryFixture())
        );

        final PaginatedResponse<PositionDiscount> response = client
            .getDiscountResource()
            .fetchPositionDiscounts(
                GenericListQueryRequest.builder().limit(1).page(1).build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(1);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(1);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchPositionDiscount() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionDiscountFetchFixture())
        );

        final PositionDiscount response = client
            .getDiscountResource()
            .fetchPositionDiscount(1L);

        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getDiscount()).isEqualTo(20);
        assertThat(response.getDiscountType()).isEqualTo(DiscountType.PERCENT);
        assertThat(response.getPositionId()).isEqualTo(14L);
    }

    @Test
    public void testCreatePositionDiscount() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionDiscountCreateFixture())
        );

        final PositionDiscount response = client
            .getDiscountResource()
            .createPositionDiscount(
                PositionDiscountRequest
                    .builder()
                    .customerId(1L)
                    .positionId(1L)
                    .discount(10.5F)
                    .discountType(DiscountType.PERCENT)
                    .build()
            );

        assertThat(response.getId()).isEqualTo(3L);
        assertThat(response.getDiscount()).isEqualTo(10.5F);
        assertThat(response.getDiscountType()).isEqualTo(DiscountType.PERCENT);
        assertThat(response.getPositionId()).isEqualTo(1L);
    }

    @Test
    public void testUpdatePositionDiscount() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionDiscountUpdateFixture())
        );

        final PositionDiscount response = client
            .getDiscountResource()
            .updatePositionDiscount(
                3L,
                PositionDiscountRequest.builder().discount(12.7F).build()
            );

        assertThat(response.getId()).isEqualTo(3L);
        assertThat(response.getDiscount()).isEqualTo(12.7F);
    }

    @Test
    public void testDeletePositionDiscount() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionDiscountDeleteFixture())
        );

        client.getDiscountResource().deletePositionDiscount(3L);
    }

    @Test
    public void testFetchPositionGroupDiscounts() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionGroupDiscountFetchListWithQueryFixture())
        );

        final PaginatedResponse<PositionGroupDiscount> response = client
            .getDiscountResource()
            .fetchPositionGroupDiscounts(
                GenericListQueryRequest.builder().limit(1).page(1).build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(1);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(1);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchPositionGroupDiscount() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionGroupDiscountFetchFixture())
        );

        final PositionGroupDiscount response = client
            .getDiscountResource()
            .fetchPositionGroupDiscount(2L);

        assertThat(response.getId()).isEqualTo(2L);
    }

    @Test
    public void testCreatePositionGroupDiscount() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionGroupDiscountCreateFixture())
        );

        final PositionGroupDiscount response = client
            .getDiscountResource()
            .createPositionGroupDiscount(
                PositionGroupDiscountRequest
                    .builder()
                    .customerId(9L)
                    .discount(10.5F)
                    .discountType(DiscountType.PERCENT)
                    .positionGroupId(2L)
                    .build()
            );

        assertThat(response.getId()).isEqualTo(5L);
        assertThat(response.getDiscount()).isEqualTo(10.5F);
        assertThat(response.getDiscountType()).isEqualTo(DiscountType.PERCENT);
        assertThat(response.getPositionGroupId()).isEqualTo(2L);
    }

    @Test
    public void testUpdatePositionGroupDiscount() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionGroupDiscountUpdateFixture())
        );

        final PositionGroupDiscount response = client
            .getDiscountResource()
            .updatePositionGroupDiscount(
                5L,
                PositionGroupDiscountRequest.builder().discount(17.0F).build()
            );

        assertThat(response.getId()).isEqualTo(5L);
        assertThat(response.getDiscount()).isEqualTo(17.0F);
    }

    @Test
    public void testDeletePositionGroupDiscount() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new PositionGroupDiscountDeleteFixture())
        );

        client.getDiscountResource().deletePositionGroupDiscount(5L);
    }
}
