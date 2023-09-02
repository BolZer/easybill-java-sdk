package io.github.bolzer.easybill_java_sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.contracts.QueryRequest;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestClientException;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestServerException;
import io.github.bolzer.easybill_java_sdk.interceptors.BearerAuthorizationInterceptor;
import io.github.bolzer.easybill_java_sdk.interceptors.UserAgentInterceptor;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import okhttp3.*;
import okio.BufferedSource;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class HttpClientWrapper implements HttpClient {

    @NonNull
    private final OkHttpClient okHttpClient;

    public HttpClientWrapper(@NonNull String apiToken) {
        this.okHttpClient =
            new OkHttpClient.Builder()
                .followRedirects(false)
                .addInterceptor(new UserAgentInterceptor(Client.USER_AGENT))
                .addInterceptor(new BearerAuthorizationInterceptor(apiToken))
                .callTimeout(Duration.ofSeconds(30))
                .connectTimeout(Duration.ofSeconds(30))
                .build();
    }

    @Override
    public void doDeleteRequest(@NonNull String endpoint)
        throws EasybillRestException {
        final Request request = new Request.Builder()
            .method("DELETE", null)
            .url(this.buildUrl(endpoint, null))
            .build();

        try (Response response = this.okHttpClient.newCall(request).execute()) {
            this.inspectResponse(response);
        } catch (IOException exception) {
            throw new EasybillRestException("request failed");
        }
    }

    @Override
    public void doPostRequestWithoutPayload(@NonNull String endpoint)
        throws EasybillRestException {
        final Request request = new Request.Builder()
            .method("POST", RequestBody.create(new byte[] {}, null))
            .url(this.buildUrl(endpoint, null))
            .build();

        try (Response response = this.okHttpClient.newCall(request).execute()) {
            this.inspectResponse(response);
        } catch (IOException exception) {
            throw new EasybillRestException("request failed");
        }
    }

    @Override
    public void doPostRequestWithPayload(
        @NonNull String endpoint,
        @NonNull Object payload
    ) throws EasybillRestException {
        try {
            final RequestBody requestBody = RequestBody.create(
                this.getPreparedObjectMapper().writeValueAsString(payload),
                MediaType.parse("application/json; charset=utf-8")
            );

            final Request request = new Request.Builder()
                .method("POST", requestBody)
                .url(this.buildUrl(endpoint, null))
                .build();

            try (
                Response response = this.okHttpClient.newCall(request).execute()
            ) {
                this.inspectResponse(response);
            } catch (IOException e) {
                throw new EasybillRestException("request failed");
            }
        } catch (JsonProcessingException e) {
            throw new EasybillRestException("request failed");
        }
    }

    @Override
    public byte[] downloadFile(@NonNull String endpoint)
        throws EasybillRestException {
        final Request request = new Request.Builder()
            .method("GET", null)
            .url(this.buildUrl(endpoint, null))
            .build();

        try (Response response = this.okHttpClient.newCall(request).execute()) {
            this.inspectResponse(response);

            try (ResponseBody responseBody = response.body()) {
                if (responseBody == null) {
                    throw new IllegalStateException("ResponseBody is null");
                }

                try (BufferedSource bufferedSource = responseBody.source()) {
                    return bufferedSource.readByteArray();
                }
            }
        } catch (IOException e) {
            throw new EasybillRestException("request failed");
        }
    }

    @Override
    public @NonNull <
        T extends @Initialized @NonNull Object
    > T doGetRequestAndMarshalJsonInto(
        @NonNull String endpoint,
        @Nullable QueryRequest request,
        TypeReference<T> typeReferenceOfReturnValue
    ) throws EasybillRestException {
        try (Response response = this.doGetRequest(endpoint, request)) {
            return this.handleResponseAndReturnTypeByReference(
                    response,
                    typeReferenceOfReturnValue
                );
        }
    }

    @Override
    public @NonNull <
        T extends @Initialized @NonNull Object
    > T doPostRequestAndMarshalJsonInto(
        @NonNull String endpoint,
        @NonNull Object payload,
        TypeReference<T> typeReferenceOfReturnValue
    ) throws EasybillRestException {
        try (
            Response response = this.doJsonRequestWithMethod(
                    "POST",
                    endpoint,
                    this.getPreparedObjectMapper().writeValueAsString(payload)
                )
        ) {
            return this.handleResponseAndReturnTypeByReference(
                    response,
                    typeReferenceOfReturnValue
                );
        } catch (JsonProcessingException jsonProcessingException) {
            throw new EasybillRestException("request failed");
        }
    }

    @Override
    public @NonNull <
        T extends @Initialized @NonNull Object
    > T doPutRequestAndMarshalJsonInto(
        @NonNull String endpoint,
        @NonNull Object payload,
        TypeReference<T> typeReferenceOfReturnValue
    ) throws EasybillRestException {
        try (
            Response response = this.doJsonRequestWithMethod(
                    "PUT",
                    endpoint,
                    this.getPreparedObjectMapper().writeValueAsString(payload)
                )
        ) {
            return this.handleResponseAndReturnTypeByReference(
                    response,
                    typeReferenceOfReturnValue
                );
        } catch (JsonProcessingException jsonProcessingException) {
            throw new EasybillRestException("request failed");
        }
    }

    private @NonNull Response doGetRequest(
        @NonNull String endpoint,
        @Nullable QueryRequest queryRequest
    ) throws EasybillRestException {
        final Request request = new Request.Builder()
            .method("GET", null)
            .url(this.buildUrl(endpoint, queryRequest))
            .build();

        try {
            return this.okHttpClient.newCall(request).execute();
        } catch (IOException exception) {
            throw new EasybillRestException("request failed");
        }
    }

    private @NonNull Response doJsonRequestWithMethod(
        @NonNull String method,
        @NonNull String endpoint,
        @NonNull String bodyAsJson
    ) throws EasybillRestException {
        final RequestBody requestBody = RequestBody.create(
            bodyAsJson,
            MediaType.parse("application/json; charset=utf-8")
        );

        final Request request = new Request.Builder()
            .method(method, requestBody)
            .url(this.buildUrl(endpoint, null))
            .build();

        try {
            return this.okHttpClient.newCall(request).execute();
        } catch (IOException exception) {
            throw new EasybillRestException("request failed");
        }
    }

    private <
        T extends @Initialized @NonNull Object
    > T handleResponseAndReturnTypeByReference(
        Response response,
        TypeReference<T> typeReference
    ) throws EasybillRestException {
        this.inspectResponse(response);
        return this.readResponseBodyAndMarshalToType(response, typeReference);
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
            /*switch (statusCode){
                case 400 -> this.handleBadRequest();
                case 404 -> this.handleNotFound();
                case 429 -> this.handleTooManyRequests();
                default -> this.handleGenericClientError();
            }*/

            Map<String, Object> errorResponse =
                this.readResponseBodyAndMarshalToType(
                        response,
                        new TypeReference<HashMap<String, Object>>() {}
                    );

            throw new EasybillRestClientException(
                "received status code: " +
                statusCode +
                ". internal error code: " +
                errorResponse.get("code") +
                ". error: " +
                errorResponse.get("message")
            );
        }

        if (statusCode >= 500 && statusCode <= 599) {
            throw new EasybillRestServerException(
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

    private void handleBadRequest() {}

    private void handleNotFound() {}

    private void handleTooManyRequests() {}

    private void handleGenericClientError() {}
}
