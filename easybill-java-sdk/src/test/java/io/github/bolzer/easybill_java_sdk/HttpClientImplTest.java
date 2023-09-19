package io.github.bolzer.easybill_java_sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.bolzer.easybill_java_sdk.contracts.QueryRequest;
import io.github.bolzer.easybill_java_sdk.requests.DocumentListQueryRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;
import kotlin.Triple;
import okhttp3.HttpUrl;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.Test;
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
    public void testHttpClientConfig(){}
}
