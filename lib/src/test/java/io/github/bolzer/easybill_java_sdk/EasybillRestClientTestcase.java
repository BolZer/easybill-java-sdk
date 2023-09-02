package io.github.bolzer.easybill_java_sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.jupiter.api.AfterEach;

public class EasybillRestClientTestcase {

    private static MockWebServer mockWebServer;

    @AfterEach
    void afterEach() throws IOException {
        if (mockWebServer == null) {
            return;
        }

        mockWebServer.close();
    }

    public static Client bootstrapMockWebServerAndReturnClient(
        List<@NonNull Fixture> fixtures
    ) {
        final okhttp3.mockwebserver.Dispatcher dispatcher = new Dispatcher() {
            @Override
            public @NonNull MockResponse dispatch(
                @NonNull RecordedRequest request
            ) {
                for (Fixture fixture : fixtures) {
                    if (
                        !Objects.equals(
                            request.getMethod(),
                            fixture.getRequestMethod()
                        )
                    ) {
                        continue;
                    }

                    if (
                        !Objects.equals(
                            request.getPath(),
                            fixture.getRequestUrl()
                        )
                    ) {
                        continue;
                    }

                    if (request.getBody().size() != 0) {
                        try {
                            ObjectMapper ojm = new ObjectMapper();

                            var rawRequestBody = ojm.readValue(
                                request.getBody().readByteArray(),
                                new TypeReference<Map<String, ?>>() {}
                            );

                            var rawFixtureRequestBody = ojm.readValue(
                                ojm.writeValueAsString(fixture.getPostBody()),
                                new TypeReference<Map<String, ?>>() {}
                            );

                            if (!rawRequestBody.equals(rawFixtureRequestBody)) {
                                continue;
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    return fixture.getResponse();
                }

                throw new RuntimeException(
                    "request does not match anything loaded in the dispatcher"
                );
            }
        };

        try {
            MockWebServer server = new MockWebServer();
            EasybillRestClientTestcase.mockWebServer = server;
            mockWebServer.setDispatcher(dispatcher);
            mockWebServer.start();
            Client client = new Client("something");
            Client.BASE_URL = mockWebServer.url("/rest/v1").toString();
            return client;
        } catch (IOException exception) {
            throw new RuntimeException("starting of mock web server failed");
        }
    }
}
