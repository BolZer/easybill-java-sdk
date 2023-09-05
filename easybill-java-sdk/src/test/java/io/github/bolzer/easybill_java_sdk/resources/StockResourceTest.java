package io.github.bolzer.easybill_java_sdk.resources;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.EasybillRestClientTestcase;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.fixtures.stocks.StockCreateFixture;
import io.github.bolzer.easybill_java_sdk.fixtures.stocks.StockFetchFixture;
import io.github.bolzer.easybill_java_sdk.fixtures.stocks.StockFetchListWithQueryFixture;
import io.github.bolzer.easybill_java_sdk.models.Stock;
import io.github.bolzer.easybill_java_sdk.requests.StockListQueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.StockRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

public final class StockResourceTest extends EasybillRestClientTestcase {

    @Test
    public void testFetchStocks() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new StockFetchListWithQueryFixture())
        );

        final PaginatedResponse<Stock> response = client
            .getStockResource()
            .fetchStocks(
                StockListQueryRequest.builder().limit(1).page(1).build()
            );

        assertThat(response.page()).isEqualTo(1);
        assertThat(response.pages()).isEqualTo(9);
        assertThat(response.limit()).isEqualTo(1);
        assertThat(response.total()).isEqualTo(9);
        assertThat(response.items().size()).isEqualTo(1);
    }

    @Test
    public void testFetchStock() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new StockFetchFixture())
        );

        final Stock response = client.getStockResource().fetchStock(9L);

        assertThat(response.id()).isEqualTo(9L);
    }

    @Test
    public void testCreateStock() throws EasybillRestException {
        Client client = bootstrapMockWebServerAndReturnClient(
            List.of(new StockCreateFixture())
        );

        final Stock response = client
            .getStockResource()
            .createStock(
                StockRequest
                    .builder()
                    .note("00010")
                    .stockCount(100L)
                    .positionId(2)
                    .build()
            );

        assertThat(response.note()).isEqualTo("00010");
        assertThat(response.stockCount()).isEqualTo(100L);
    }
}
