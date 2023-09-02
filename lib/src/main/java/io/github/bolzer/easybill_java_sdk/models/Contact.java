package io.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record Contact(
    @JsonProperty("id") long id,
    @JsonProperty("login_id") long loginId,
    @JsonProperty("personal") boolean personal,
    @JsonProperty("salutation") int salutation,
    @JsonProperty("first_name") @NonNull String firstName,
    @JsonProperty("last_name") @NonNull String lastName,
    @JsonProperty("phone_1") @NonNull String phone1,
    @JsonProperty("phone_2") @NonNull String phone2,
    @JsonProperty("mobile") @NonNull String mobile,
    @JsonProperty("note") @NonNull String note,
    @JsonProperty("city") @NonNull String city,
    @JsonProperty("state") @NonNull String state,
    @JsonProperty("zip_code") @NonNull String zipCode,
    @JsonProperty("street") @NonNull String street,
    @JsonProperty("company_name") @Nullable String companyName,
    @JsonProperty("country") @NonNull String country,
    @JsonProperty("department") @NonNull String department,
    @JsonProperty("emails") @NonNull List<@NonNull String> emails,
    @JsonProperty("suffix_1") @NonNull String suffix1,
    @JsonProperty("suffix_2") @NonNull String suffix2,
    @JsonProperty("title") @NonNull String title,
    @JsonProperty("fax") @NonNull String fax,
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NonNull
    LocalDateTime createdAt,
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NonNull
    LocalDateTime updatedAt
) {
    public Contact(
        @JsonProperty("id") long id,
        @JsonProperty("login_id") long loginId,
        @JsonProperty("personal") boolean personal,
        @JsonProperty("salutation") int salutation,
        @JsonProperty("first_name") @NonNull String firstName,
        @JsonProperty("last_name") @NonNull String lastName,
        @JsonProperty("phone_1") @NonNull String phone1,
        @JsonProperty("phone_2") @NonNull String phone2,
        @JsonProperty("mobile") @NonNull String mobile,
        @JsonProperty("note") @NonNull String note,
        @JsonProperty("city") @NonNull String city,
        @JsonProperty("state") @NonNull String state,
        @JsonProperty("zip_code") @NonNull String zipCode,
        @JsonProperty("street") @NonNull String street,
        @JsonProperty("company_name") @Nullable String companyName,
        @JsonProperty("country") @NonNull String country,
        @JsonProperty("department") @NonNull String department,
        @JsonProperty("emails") @NonNull List<@NonNull String> emails,
        @JsonProperty("suffix_1") @NonNull String suffix1,
        @JsonProperty("suffix_2") @NonNull String suffix2,
        @JsonProperty("title") @NonNull String title,
        @JsonProperty("fax") @NonNull String fax,
        @JsonProperty("created_at") @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
        ) @NonNull LocalDateTime createdAt,
        @JsonProperty("updated_at") @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
        ) @NonNull LocalDateTime updatedAt
    ) {
        this.id = id;
        this.loginId = loginId;
        this.personal = personal;
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.mobile = mobile;
        this.note = note;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.companyName = companyName;
        this.country = country;
        this.department = department;
        this.emails = Collections.unmodifiableList(emails);
        this.suffix1 = suffix1;
        this.suffix2 = suffix2;
        this.title = title;
        this.fax = fax;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.street = street;
    }
}
