package com.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record Customer(
    @JsonProperty("acquire_options") int acquireOptions,
    @JsonProperty("additional_groups_ids")
    @NonNull
    List<@NonNull Long> additionalGroupsIds,
    @JsonProperty("bank_account") @Nullable String bankAccount,
    @JsonProperty("bank_account_owner") @Nullable String bankAccountOwner,
    @JsonProperty("bank_bic") @Nullable String bankBic,
    @JsonProperty("bank_code") @Nullable String bankCode,
    @JsonProperty("bank_iban") @Nullable String bankIban,
    @JsonProperty("bank_name") @Nullable String bankName,
    @JsonProperty("birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Nullable
    LocalDate birthDate,
    @JsonProperty("cash_allowance") @Nullable Float cashAllowance,
    @JsonProperty("cash_allowance_days") @Nullable Integer cashAllowanceDays,
    @JsonProperty("cash_discount") @Nullable Float cashDiscount,
    @JsonProperty("city") @NonNull String city,
    @JsonProperty("state") @NonNull String state,
    @JsonProperty("company_name") @NonNull String companyName,
    @JsonProperty("country") @NonNull String country,
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NonNull
    LocalDate createdAt,
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NonNull
    LocalDateTime updatedAt,
    @JsonProperty("delivery_title") @NonNull String deliveryTitle,
    @JsonProperty("delivery_city") @Nullable String deliveryCity,
    @JsonProperty("delivery_state") @NonNull String deliveryState,
    @JsonProperty("delivery_company_name") @Nullable String deliveryCompanyName,
    @JsonProperty("delivery_country") @Nullable String deliveryCountry,
    @JsonProperty("delivery_first_name") @Nullable String deliveryFirstName,
    @JsonProperty("delivery_last_name") @Nullable String deliveryLastName,
    @JsonProperty("delivery_personal") boolean deliveryPersonal,
    @JsonProperty("delivery_salutation") int deliverySalutation,
    @JsonProperty("delivery_street") @Nullable String deliveryStreet,
    @JsonProperty("delivery_suffix_1") @Nullable String deliverySuffix1,
    @JsonProperty("delivery_suffix_2") @Nullable String deliverySuffix2,
    @JsonProperty("delivery_zip_code") @Nullable String deliveryZipCode,
    @JsonProperty("display_name") @NonNull String displayName,
    @JsonProperty("emails") @NonNull List<@NonNull String> emails,
    @JsonProperty("fax") @Nullable String fax,
    @JsonProperty("first_name") @NonNull String firstName,
    @JsonProperty("grace_period") @Nullable Integer gracePeriod,
    @JsonProperty("due_in_days") @Nullable Integer dueInDays,
    @JsonProperty("group_id") @Nullable Integer groupId,
    @JsonProperty("id") long id,
    @JsonProperty("info_1") @Nullable String info1,
    @JsonProperty("info_2") @Nullable String info2,
    @JsonProperty("internet") @Nullable String internet,
    @JsonProperty("last_name") @NonNull String lastName,
    @JsonProperty("login_id") long loginId,
    @JsonProperty("mobile") @Nullable String mobile,
    @JsonProperty("note") @Nullable String note,
    @JsonProperty("number") @NonNull String number,
    @JsonProperty("payment_options") @Nullable Integer paymentOptions,
    @JsonProperty("personal") boolean personal,
    @JsonProperty("phone_1") @Nullable String phone1,
    @JsonProperty("phone_2") @Nullable String phone2,
    @JsonProperty("postbox") @Nullable String postbox,
    @JsonProperty("postbox_city") @Nullable String postboxCity,
    @JsonProperty("postbox_state") @NonNull String postboxState,
    @JsonProperty("postbox_country") @Nullable String postboxCountry,
    @JsonProperty("postbox_zip_code") @Nullable String postboxZipCode,
    @JsonProperty("salutation") int salutation,
    @JsonProperty("sepa_agreement_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Nullable
    LocalDate sepaAgreementDate,
    @JsonProperty("sepa_mandate_reference")
    @Nullable
    String sepaMandateReference,
    @JsonProperty("since_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Nullable
    LocalDate sinceDate,
    @JsonProperty("street") @NonNull String street,
    @JsonProperty("suffix_1") @Nullable String suffix1,
    @JsonProperty("suffix_2") @Nullable String suffix2,
    @JsonProperty("tax_number") @Nullable String taxNumber,
    @JsonProperty("court") @Nullable String court,
    @JsonProperty("court_registry_number") @Nullable String courtRegistryNumber,
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("archived") boolean archived,
    @JsonProperty("vat_identifier") @Nullable String vatIdentifier,
    @JsonProperty("zip_code") @NonNull String zipCode,
    @JsonProperty("buyer_reference") @NonNull String buyerReference,
    @JsonProperty("foreign_supplier_number")
    @NonNull
    String foreignSupplierNumber
) {
    public Customer(
        @JsonProperty("acquire_options") int acquireOptions,
        @JsonProperty(
            "additional_groups_ids"
        ) @NonNull List<@NonNull Long> additionalGroupsIds,
        @JsonProperty("bank_account") @Nullable String bankAccount,
        @JsonProperty("bank_account_owner") @Nullable String bankAccountOwner,
        @JsonProperty("bank_bic") @Nullable String bankBic,
        @JsonProperty("bank_code") @Nullable String bankCode,
        @JsonProperty("bank_iban") @Nullable String bankIban,
        @JsonProperty("bank_name") @Nullable String bankName,
        @JsonProperty("birth_date") @JsonFormat(
            pattern = "yyyy-MM-dd"
        ) @Nullable LocalDate birthDate,
        @JsonProperty("cash_allowance") @Nullable Float cashAllowance,
        @JsonProperty(
            "cash_allowance_days"
        ) @Nullable Integer cashAllowanceDays,
        @JsonProperty("cash_discount") @Nullable Float cashDiscount,
        @JsonProperty("city") @NonNull String city,
        @JsonProperty("state") @NonNull String state,
        @JsonProperty("company_name") @NonNull String companyName,
        @JsonProperty("country") @NonNull String country,
        @JsonProperty("created_at") @JsonFormat(
            pattern = "yyyy-MM-dd"
        ) @NonNull LocalDate createdAt,
        @JsonProperty("updated_at") @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
        ) @NonNull LocalDateTime updatedAt,
        @JsonProperty("delivery_title") @NonNull String deliveryTitle,
        @JsonProperty("delivery_city") @Nullable String deliveryCity,
        @JsonProperty("delivery_state") @NonNull String deliveryState,
        @JsonProperty(
            "delivery_company_name"
        ) @Nullable String deliveryCompanyName,
        @JsonProperty("delivery_country") @Nullable String deliveryCountry,
        @JsonProperty("delivery_first_name") @Nullable String deliveryFirstName,
        @JsonProperty("delivery_last_name") @Nullable String deliveryLastName,
        @JsonProperty("delivery_personal") boolean deliveryPersonal,
        @JsonProperty("delivery_salutation") int deliverySalutation,
        @JsonProperty("delivery_street") @Nullable String deliveryStreet,
        @JsonProperty("delivery_suffix_1") @Nullable String deliverySuffix1,
        @JsonProperty("delivery_suffix_2") @Nullable String deliverySuffix2,
        @JsonProperty("delivery_zip_code") @Nullable String deliveryZipCode,
        @JsonProperty("display_name") @NonNull String displayName,
        @JsonProperty("emails") @NonNull List<@NonNull String> emails,
        @JsonProperty("fax") @Nullable String fax,
        @JsonProperty("first_name") @NonNull String firstName,
        @JsonProperty("grace_period") @Nullable Integer gracePeriod,
        @JsonProperty("due_in_days") @Nullable Integer dueInDays,
        @JsonProperty("group_id") @Nullable Integer groupId,
        @JsonProperty("id") long id,
        @JsonProperty("info_1") @Nullable String info1,
        @JsonProperty("info_2") @Nullable String info2,
        @JsonProperty("internet") @Nullable String internet,
        @JsonProperty("last_name") @NonNull String lastName,
        @JsonProperty("login_id") long loginId,
        @JsonProperty("mobile") @Nullable String mobile,
        @JsonProperty("note") @Nullable String note,
        @JsonProperty("number") @NonNull String number,
        @JsonProperty("payment_options") @Nullable Integer paymentOptions,
        @JsonProperty("personal") boolean personal,
        @JsonProperty("phone_1") @Nullable String phone1,
        @JsonProperty("phone_2") @Nullable String phone2,
        @JsonProperty("postbox") @Nullable String postbox,
        @JsonProperty("postbox_city") @Nullable String postboxCity,
        @JsonProperty("postbox_state") @NonNull String postboxState,
        @JsonProperty("postbox_country") @Nullable String postboxCountry,
        @JsonProperty("postbox_zip_code") @Nullable String postboxZipCode,
        @JsonProperty("salutation") int salutation,
        @JsonProperty("sepa_agreement_date") @JsonFormat(
            pattern = "yyyy-MM-dd"
        ) @Nullable LocalDate sepaAgreementDate,
        @JsonProperty(
            "sepa_mandate_reference"
        ) @Nullable String sepaMandateReference,
        @JsonProperty("since_date") @JsonFormat(
            pattern = "yyyy-MM-dd"
        ) @Nullable LocalDate sinceDate,
        @JsonProperty("street") @NonNull String street,
        @JsonProperty("suffix_1") @Nullable String suffix1,
        @JsonProperty("suffix_2") @Nullable String suffix2,
        @JsonProperty("tax_number") @Nullable String taxNumber,
        @JsonProperty("court") @Nullable String court,
        @JsonProperty(
            "court_registry_number"
        ) @Nullable String courtRegistryNumber,
        @JsonProperty("title") @Nullable String title,
        @JsonProperty("archived") boolean archived,
        @JsonProperty("vat_identifier") @Nullable String vatIdentifier,
        @JsonProperty("zip_code") @NonNull String zipCode,
        @JsonProperty("buyer_reference") @NonNull String buyerReference,
        @JsonProperty(
            "foreign_supplier_number"
        ) @NonNull String foreignSupplierNumber
    ) {
        this.acquireOptions = acquireOptions;
        this.additionalGroupsIds =
            Collections.unmodifiableList(additionalGroupsIds);
        this.bankAccount = bankAccount;
        this.bankAccountOwner = bankAccountOwner;
        this.bankBic = bankBic;
        this.bankCode = bankCode;
        this.bankIban = bankIban;
        this.bankName = bankName;
        this.birthDate = birthDate;
        this.cashAllowance = cashAllowance;
        this.cashAllowanceDays = cashAllowanceDays;
        this.cashDiscount = cashDiscount;
        this.city = city;
        this.state = state;
        this.companyName = companyName;
        this.country = country;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deliveryTitle = deliveryTitle;
        this.deliveryCity = deliveryCity;
        this.deliveryState = deliveryState;
        this.deliveryCompanyName = deliveryCompanyName;
        this.deliveryCountry = deliveryCountry;
        this.deliveryFirstName = deliveryFirstName;
        this.deliveryLastName = deliveryLastName;
        this.deliveryPersonal = deliveryPersonal;
        this.deliverySalutation = deliverySalutation;
        this.deliveryStreet = deliveryStreet;
        this.deliverySuffix1 = deliverySuffix1;
        this.deliverySuffix2 = deliverySuffix2;
        this.deliveryZipCode = deliveryZipCode;
        this.displayName = displayName;
        this.emails = Collections.unmodifiableList(emails);
        this.fax = fax;
        this.firstName = firstName;
        this.gracePeriod = gracePeriod;
        this.dueInDays = dueInDays;
        this.groupId = groupId;
        this.id = id;
        this.info1 = info1;
        this.info2 = info2;
        this.internet = internet;
        this.lastName = lastName;
        this.loginId = loginId;
        this.mobile = mobile;
        this.note = note;
        this.number = number;
        this.paymentOptions = paymentOptions;
        this.personal = personal;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.postbox = postbox;
        this.postboxCity = postboxCity;
        this.postboxState = postboxState;
        this.postboxCountry = postboxCountry;
        this.postboxZipCode = postboxZipCode;
        this.salutation = salutation;
        this.sepaAgreementDate = sepaAgreementDate;
        this.sepaMandateReference = sepaMandateReference;
        this.sinceDate = sinceDate;
        this.street = street;
        this.suffix1 = suffix1;
        this.suffix2 = suffix2;
        this.taxNumber = taxNumber;
        this.court = court;
        this.courtRegistryNumber = courtRegistryNumber;
        this.title = title;
        this.archived = archived;
        this.vatIdentifier = vatIdentifier;
        this.zipCode = zipCode;
        this.buyerReference = buyerReference;
        this.foreignSupplierNumber = foreignSupplierNumber;
    }
}
