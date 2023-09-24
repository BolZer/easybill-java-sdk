package io.github.bolzer.easybill_java_sdk.interceptors;

import java.util.ArrayList;
import java.util.List;
import okhttp3.logging.HttpLoggingInterceptor;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

public final class LoggingInterceptorBuilder {

    public interface LogFunc extends HttpLoggingInterceptor.Logger {
        void log(@NotNull String message);
    }

    private LogFunc loggingFunction = message -> {};

    @NonNull
    private List<@NonNull String> redactHeaders = new ArrayList<>();

    private HttpLoggingInterceptor.@NonNull Level loggingLevel =
        HttpLoggingInterceptor.Level.BASIC;

    public LoggingInterceptorBuilder setLoggingLevel(
        HttpLoggingInterceptor.Level level
    ) {
        this.loggingLevel = level;
        return this;
    }

    public LoggingInterceptorBuilder setLoggingFunction(
        LogFunc loggingFunction
    ) {
        this.loggingFunction = loggingFunction;
        return this;
    }

    public LoggingInterceptorBuilder setRedactHeaders(
        @NonNull List<@NonNull String> headers
    ) {
        this.redactHeaders = List.copyOf(headers);
        return this;
    }

    public @NonNull HttpLoggingInterceptor build() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
            this.loggingFunction
        );

        interceptor.setLevel(this.loggingLevel);

        redactHeaders.forEach(interceptor::redactHeader);

        return interceptor;
    }
}
