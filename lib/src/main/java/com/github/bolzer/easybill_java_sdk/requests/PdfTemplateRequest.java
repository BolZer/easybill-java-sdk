package com.github.bolzer.easybill_java_sdk.requests;

import com.github.bolzer.easybill_java_sdk.contracts.QueryRequest;
import com.github.bolzer.easybill_java_sdk.enums.DocumentType;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Getter
public final class PdfTemplateRequest implements QueryRequest {

    @Singular
    @NonNull
    private List<@NonNull DocumentType> types;

    @Override
    public @Initialized @NonNull Map<@NonNull String, @NonNull String> toStringMap() {
        final Map<String, String> map = new HashMap<>();

        if (!types.isEmpty()) {
            map.put(
                "type",
                String.join(
                    ",",
                    this.types.stream().map(String::valueOf).toList()
                )
            );
        }

        return map;
    }
}
