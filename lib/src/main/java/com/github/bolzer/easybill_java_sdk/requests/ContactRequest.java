package com.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.common.value.qual.IntRange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ContactRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private ContactRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static ContactRequestBuilder builder() {
        return new ContactRequestBuilder();
    }

    public static class ContactRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public ContactRequest build() {
            return new ContactRequest(this.parameters);
        }

        public ContactRequestBuilder street(@NonNull String street) {
            this.parameters.put("street", street);
            return this;
        }

        public ContactRequestBuilder city(@NonNull String city) {
            this.parameters.put("city", city);
            return this;
        }

        public ContactRequestBuilder state(@NonNull String state) {
            this.parameters.put("state", state);
            return this;
        }

        public ContactRequestBuilder companyName(@NonNull String companyName) {
            this.parameters.put("company_name", companyName);
            return this;
        }

        public ContactRequestBuilder firstName(@NonNull String firstName) {
            this.parameters.put("first_name", firstName);
            return this;
        }

        public ContactRequestBuilder lastName(@NonNull String lastName) {
            this.parameters.put("last_name", lastName);
            return this;
        }

        public ContactRequestBuilder country(@NonNull String country) {
            this.parameters.put("country", country);
            return this;
        }

        public ContactRequestBuilder zipCode(@NonNull String zipCode) {
            this.parameters.put("zip_code", zipCode);
            return this;
        }

        public ContactRequestBuilder title(@NonNull String title) {
            this.parameters.put("title", title);
            return this;
        }

        public ContactRequestBuilder department(@NonNull String department) {
            this.parameters.put("department", department);
            return this;
        }

        public ContactRequestBuilder phone1(@NonNull String phone1) {
            this.parameters.put("phone_1", phone1);
            return this;
        }

        public ContactRequestBuilder phone2(@NonNull String phone2) {
            this.parameters.put("phone_2", phone2);
            return this;
        }

        public ContactRequestBuilder suffix1(@NonNull String suffix1) {
            this.parameters.put("suffix_1", suffix1);
            return this;
        }

        public ContactRequestBuilder suffix2(@NonNull String suffix2) {
            this.parameters.put("suffix_2", suffix2);
            return this;
        }

        public ContactRequestBuilder note(@NonNull String note) {
            this.parameters.put("note", note);
            return this;
        }

        public ContactRequestBuilder mobile(@NonNull String mobile) {
            this.parameters.put("mobile", mobile);
            return this;
        }

        public ContactRequestBuilder emails(
            @NonNull List<@NonNull String> emails
        ) {
            this.parameters.put("emails", emails);
            return this;
        }

        public ContactRequestBuilder salutation(
            @IntRange(from = 1, to = 6) int salutation
        ) {
            this.parameters.put("salutation", salutation);
            return this;
        }
    }
}
