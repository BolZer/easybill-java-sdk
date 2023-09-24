package io.github.bolzer.easybill_java_sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.contracts.QueryRequest;
import io.github.bolzer.easybill_java_sdk.exceptions.*;
import io.github.bolzer.easybill_java_sdk.interceptors.BearerAuthorizationInterceptor;
import io.github.bolzer.easybill_java_sdk.interceptors.LoggingInterceptorBuilder;
import io.github.bolzer.easybill_java_sdk.interceptors.UserAgentInterceptor;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.*;
import okio.BufferedSource;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class HttpClientImpl implements HttpClient {

    private enum RequestMethod {
        GET,
        POST,
        DELETE,
        PUT,
    }

    @NonNull
    private final OkHttpClient okHttpClient;

    public HttpClientImpl(@NonNull String apiToken) {
        this.okHttpClient =
            new OkHttpClient.Builder()
                .followRedirects(false)
                .addInterceptor(new UserAgentInterceptor(Client.USER_AGENT))
                .addInterceptor(new BearerAuthorizationInterceptor(apiToken))
                .callTimeout(Duration.ofSeconds(30))
                .connectTimeout(Duration.ofSeconds(30))
                .build();
    }

    public HttpClientImpl(
        @NonNull String apiToken,
        Client.@NonNull Config config
    ) {
        final OkHttpClient.Builder client = new OkHttpClient.Builder()
            .followRedirects(false)
            .addInterceptor(new UserAgentInterceptor(Client.USER_AGENT))
            .addInterceptor(new BearerAuthorizationInterceptor(apiToken));

        LoggingInterceptorBuilder builder =
            config.getLoggingInterceptorBuilder();

        if (!Objects.isNull(builder)) {
            client.addInterceptor(builder.build());
        }

        this.okHttpClient =
            client
                .callTimeout(config.getCallTimeout())
                .connectTimeout(config.getConnectTimeout())
                .build();
    }

    public @NonNull ByteBuffer requestGetBytes(@NonNull String endpoint)
        throws EasybillRestException {
        try {
            try (
                Response response = this.request(
                        RequestMethod.GET,
                        this.buildUrl(endpoint, null),
                        null
                    )
            ) {
                this.inspectResponse(response);

                try (ResponseBody responseBody = response.body()) {
                    if (responseBody == null) {
                        throw new IllegalStateException("ResponseBody is null");
                    }

                    try (
                        BufferedSource bufferedSource = responseBody.source()
                    ) {
                        return ByteBuffer.wrap(bufferedSource.readByteArray());
                    }
                }
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed", e);
        }
    }

    public @NonNull <T extends @Initialized @NonNull Object> T requestGetJson(
        @NonNull String endpoint,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException {
        try {
            try (
                Response response = this.request(
                        RequestMethod.GET,
                        this.buildUrl(endpoint, null),
                        null
                    )
            ) {
                this.inspectResponse(response);

                return this.readResponseBodyAndMarshalToType(
                        response,
                        typeReference
                    );
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed", e);
        }
    }

    public @NonNull <T extends @Initialized @NonNull Object> T requestGetJson(
        @NonNull String endpoint,
        @Nullable QueryRequest queryRequest,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException {
        try {
            try (
                Response response = this.request(
                        RequestMethod.GET,
                        this.buildUrl(endpoint, queryRequest),
                        null
                    )
            ) {
                this.inspectResponse(response);

                return this.readResponseBodyAndMarshalToType(
                        response,
                        typeReference
                    );
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed", e);
        }
    }

    @Override
    public void requestPostEmpty(@NonNull String endpoint)
        throws EasybillRestException {
        try {
            try (
                Response response = this.request(
                        RequestMethod.POST,
                        this.buildUrl(endpoint, null),
                        RequestBody.create(new byte[] {}, null)
                    )
            ) {
                this.inspectResponse(response);
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed", e);
        }
    }

    @Override
    public <T extends @Initialized @NonNull Object> T requestPostFile(
        @NonNull String endpoint,
        @NonNull File file,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException {
        try {
            RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(
                    "file",
                    file.getName(),
                    RequestBody.create(file, null)
                )
                .build();

            try (
                Response response = this.request(
                        RequestMethod.POST,
                        this.buildUrl(endpoint, null),
                        requestBody
                    )
            ) {
                this.inspectResponse(response);

                return this.readResponseBodyAndMarshalToType(
                        response,
                        typeReference
                    );
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed", e);
        }
    }

    @Override
    public <T extends @Initialized @NonNull Object> T requestPostJson(
        @NonNull String endpoint,
        @NonNull Object payload,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException {
        try {
            final RequestBody requestBody = RequestBody.create(
                this.getPreparedObjectMapper().writeValueAsString(payload),
                MediaType.parse("application/json; charset=utf-8")
            );

            try (
                Response response = this.request(
                        RequestMethod.POST,
                        this.buildUrl(endpoint, null),
                        requestBody
                    )
            ) {
                this.inspectResponse(response);

                return this.readResponseBodyAndMarshalToType(
                        response,
                        typeReference
                    );
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed", e);
        }
    }

    @Override
    public <T extends @Initialized @NonNull Object> T requestPostJson(
        @NonNull String endpoint,
        @NonNull QueryRequest queryRequest,
        @NonNull Object payload,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException {
        try {
            final RequestBody requestBody = RequestBody.create(
                this.getPreparedObjectMapper().writeValueAsString(payload),
                MediaType.parse("application/json; charset=utf-8")
            );

            try (
                Response response = this.request(
                        RequestMethod.POST,
                        this.buildUrl(endpoint, queryRequest),
                        requestBody
                    )
            ) {
                this.inspectResponse(response);

                return this.readResponseBodyAndMarshalToType(
                        response,
                        typeReference
                    );
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed", e);
        }
    }

    @Override
    public void requestPostJson(
        @NonNull String endpoint,
        @NonNull Object payload
    ) throws EasybillRestException {
        try {
            final RequestBody requestBody = RequestBody.create(
                this.getPreparedObjectMapper().writeValueAsString(payload),
                MediaType.parse("application/json; charset=utf-8")
            );

            try (
                Response response = this.request(
                        RequestMethod.POST,
                        this.buildUrl(endpoint, null),
                        requestBody
                    )
            ) {
                this.inspectResponse(response);
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed", e);
        }
    }

    @Override
    public <T extends @Initialized @NonNull Object> T requestPutJson(
        @NonNull String endpoint,
        @NonNull Object payload,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException {
        try {
            final RequestBody requestBody = RequestBody.create(
                this.getPreparedObjectMapper().writeValueAsString(payload),
                MediaType.parse("application/json; charset=utf-8")
            );

            try (
                Response response = this.request(
                        RequestMethod.PUT,
                        this.buildUrl(endpoint, null),
                        requestBody
                    )
            ) {
                this.inspectResponse(response);

                return this.readResponseBodyAndMarshalToType(
                        response,
                        typeReference
                    );
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed", e);
        }
    }

    @Override
    public <T extends @Initialized @NonNull Object> T requestPutJson(
        @NonNull String endpoint,
        @NonNull QueryRequest queryRequest,
        @NonNull Object payload,
        @NonNull TypeReference<T> typeReference
    ) throws EasybillRestException {
        try {
            final RequestBody requestBody = RequestBody.create(
                this.getPreparedObjectMapper().writeValueAsString(payload),
                MediaType.parse("application/json; charset=utf-8")
            );

            try (
                Response response = this.request(
                        RequestMethod.PUT,
                        this.buildUrl(endpoint, queryRequest),
                        requestBody
                    )
            ) {
                this.inspectResponse(response);

                return this.readResponseBodyAndMarshalToType(
                        response,
                        typeReference
                    );
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed", e);
        }
    }

    @Override
    public void requestDelete(@NonNull String endpoint)
        throws EasybillRestException {
        try {
            try (
                Response response = this.request(
                        RequestMethod.DELETE,
                        this.buildUrl(endpoint, null),
                        null
                    )
            ) {
                this.inspectResponse(response);
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed", e);
        }
    }

    private @NonNull Response request(
        @NonNull RequestMethod requestMethod,
        @NonNull HttpUrl httpUrl,
        @Nullable RequestBody requestBody
    ) throws IOException {
        final Request request = new Request.Builder()
            .method(requestMethod.toString(), requestBody)
            .url(httpUrl)
            .build();

        return this.okHttpClient.newCall(request).execute();
    }

    private @NonNull HttpUrl buildUrl(
        @NonNull String endpoint,
        @Nullable QueryRequest queryRequest
    ) {
        final HttpUrl httpUrl = HttpUrl.parse(Client.BASE_URL + endpoint);

        if (httpUrl == null) {
            throw new RuntimeException("http url is null. should not happen.");
        }

        final HttpUrl.Builder urlBuilder = httpUrl.newBuilder();

        if (Objects.isNull(queryRequest)) {
            return urlBuilder.build();
        }

        final Map<String, String> requestAsStringMap =
            queryRequest.toStringMap();

        requestAsStringMap.forEach(urlBuilder::addQueryParameter);

        return urlBuilder.build();
    }

    private @NonNull ObjectMapper getPreparedObjectMapper() {
        return (new ObjectMapper()).configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false
            )
            .setPropertyNamingStrategy(
                new PropertyNamingStrategies.SnakeCaseStrategy()
            )
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    private void inspectResponse(Response response)
        throws EasybillRestException {
        if (response.isSuccessful()) {
            return;
        }

        final int statusCode = response.code();

        if (statusCode >= 400 && statusCode <= 499) {
            switch (statusCode) {
                case 400 -> this.handleBadRequest(response);
                case 414 -> this.handleUrlTooLong(response);
                case 429 -> this.handleTooManyRequests(response);
                default -> this.handleGenericClientError(response);
            }
        }

        if (statusCode >= 500 && statusCode <= 599) {
            throw new EasybillRestServerException(
                statusCode,
                "received status code: " + statusCode
            );
        }

        throw new EasybillRestException(
            "received unexpected status code: " + statusCode
        );
    }

    private <
        T extends @Initialized @NonNull Object
    > T readResponseBodyAndMarshalToType(
        Response response,
        TypeReference<T> typeReference
    ) {
        try (ResponseBody responseBody = response.body()) {
            if (responseBody == null) {
                throw new RuntimeException("request body is null");
            }

            final String bodyAsString = responseBody.string();

            if (Objects.equals(bodyAsString, "")) {
                throw new RuntimeException("request body is empty");
            }

            return this.getPreparedObjectMapper()
                .readValue(bodyAsString, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleBadRequest(Response response)
        throws EasybillBadRequestException {
        Map<String, Object> errorResponse =
            this.readResponseBodyAndMarshalToType(
                    response,
                    new TypeReference<HashMap<String, Object>>() {}
                );

        @SuppressWarnings("unchecked")
        List<@NonNull String> arguments =
            (List<String>) errorResponse.getOrDefault("arguments", List.of());

        throw new EasybillBadRequestException(
            response.code(),
            (int) errorResponse.getOrDefault("code", 0),
            arguments,
            (String) errorResponse.getOrDefault("message", ""),
            response.request()
        );
    }

    private void handleUrlTooLong(Response response)
        throws EasybillRequestUrlTooLongException {
        throw new EasybillRequestUrlTooLongException(
            response.code(),
            "request url is too long",
            response.request()
        );
    }

    private void handleTooManyRequests(Response response)
        throws EasybillTooManyRequestsException {
        String retryAfterHeaderValue = response.header("Retry-After");

        throw new EasybillTooManyRequestsException(
            response.code(),
            Integer.parseInt(
                retryAfterHeaderValue != null ? retryAfterHeaderValue : ""
            ),
            "request limit exceeded",
            response.request()
        );
    }

    private void handleGenericClientError(Response response)
        throws EasybillRestClientException {
        throw new EasybillRestClientException(
            response.code(),
            "received status code: " + response.code(),
            response.request()
        );
    }
}
