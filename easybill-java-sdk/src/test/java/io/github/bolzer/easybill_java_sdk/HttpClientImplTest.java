package io.github.bolzer.easybill_java_sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.github.bolzer.easybill_java_sdk.contracts.QueryRequest;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.interceptors.LoggingInterceptorBuilder;
import io.github.bolzer.easybill_java_sdk.requests.DocumentListQueryRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import kotlin.Triple;
import okhttp3.HttpUrl;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public final class HttpClientImplTest {

    static Stream<Triple<@NonNull QueryRequest, @NonNull String, @NonNull String>> provideQueryRequests() {
        return Stream.of(
            new Triple<>(
                DocumentListQueryRequest.builder().build(),
                "/documents",
                "https://api.easybill.de/rest/v1/documents?limit=100&page=1"
            ),
            new Triple<>(
                DocumentListQueryRequest
                    .builder()
                    .status("okay")
                    .cancelIds(List.of(1L, 2L, 3L))
                    .build(),
                "/documents",
                "https://api.easybill.de/rest/v1/documents?cancel_id=1%2C2%2C3&limit=100&page=1&status=okay"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideQueryRequests")
    public void testBuildUrl(
        @NonNull Triple<@NonNull QueryRequest, @NonNull String, @NonNull String> value
    )
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HttpClientImpl client = new HttpClientImpl("");

        Method buildUrlMethod = client
            .getClass()
            .getDeclaredMethod("buildUrl", String.class, QueryRequest.class);

        buildUrlMethod.setAccessible(true);

        HttpUrl result = (HttpUrl) buildUrlMethod.invoke(
            client,
            value.getSecond(),
            value.getFirst()
        );

        assertEquals(value.getThird(), result.toString());
    }

    @Test
    @SuppressFBWarnings
    public void testHttpClientConfig()
        throws EasybillRestException, IOException {
        final List<@NonNull String> log = new ArrayList<>();

        final okhttp3.mockwebserver.Dispatcher dispatcher = new Dispatcher() {
            @Override
            public @NonNull MockResponse dispatch(
                @NonNull RecordedRequest request
            ) {
                return new MockResponse().setResponseCode(200);
            }
        };

        MockWebServer server = new MockWebServer();
        server.setDispatcher(dispatcher);
        server.start();

        Client.BASE_URL = server.url("/rest/v1").toString();

        LoggingInterceptorBuilder interceptorBuilder =
            (new LoggingInterceptorBuilder()).setLoggingFunction(log::add)
                .setLoggingLevel(HttpLoggingInterceptor.Level.HEADERS)
                .setRedactHeaders(List.of("Authorization"));

        HttpClientImpl client = new HttpClientImpl(
            "TEST_TOKEN",
            new Client.Config(
                Duration.ofSeconds(30),
                Duration.ofSeconds(30),
                interceptorBuilder
            )
        );

        client.requestDelete("/test");
        assertThat(log).contains("User-Agent: easybill-JAVA-REST-SDK-0.5.0");
        assertThat(log).contains("Authorization: ██");
    }
}
