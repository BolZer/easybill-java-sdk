package com.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.bolzer.easybill_java_sdk.enums.LoginType;
import org.checkerframework.checker.nullness.qual.NonNull;

public record Login(
    @JsonProperty("display_name") @NonNull String displayName,
    @JsonProperty("email") @NonNull String email,
    @JsonProperty("email_signature") @NonNull String emailSignature,
    @JsonProperty("first_name") @NonNull String firstName,
    @JsonProperty("id") long id,
    @JsonProperty("last_name") @NonNull String lastName,
    @JsonProperty("locale") @NonNull String locale,
    @JsonProperty("login_type") @NonNull LoginType loginType,
    @JsonProperty("phone") @NonNull String phone,
    @JsonProperty("time_zone") @NonNull String timeZone,
    @JsonProperty("security") @NonNull LoginSecurity security
) {
    public record LoginSecurity(
        @JsonProperty("two_factor_enabled") boolean twoFactorEnabled,
        @JsonProperty("notify_on_new_login_enabled")
        boolean notifyOnNewLoginEnabled,
        @JsonProperty("recovery_codes_enabled") boolean recoveryCodesEnabled
    ) {}
}
