package io.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.bolzer.easybill_java_sdk.enums.DiscountType;
import io.github.bolzer.easybill_java_sdk.enums.DocumentPdfType;
import io.github.bolzer.easybill_java_sdk.enums.SepaAgreement;
import io.github.bolzer.easybill_java_sdk.enums.VatOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.common.value.qual.IntRange;

public final class CustomerRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private CustomerRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static CustomerRequestBuilder builder() {
        return new CustomerRequestBuilder();
    }

    public static class CustomerRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public CustomerRequest build() {
            return new CustomerRequest(this.parameters);
        }

        public CustomerRequestBuilder acquireOptions(int acquireOptions) {
            this.parameters.put("acquire_options", acquireOptions);
            return this;
        }

        public CustomerRequestBuilder additionalGroupIds(
            List<@NonNull Long> additionalGroupIds
        ) {
            this.parameters.put("additional_groups_ids", additionalGroupIds);
            return this;
        }

        public CustomerRequestBuilder bankAccount(@NonNull String bankAccount) {
            this.parameters.put("bank_account", bankAccount);
            return this;
        }

        public CustomerRequestBuilder bankAccountOwner(
            @NonNull String bankAccountOwner
        ) {
            this.parameters.put("bank_account_owner", bankAccountOwner);
            return this;
        }

        public CustomerRequestBuilder bankIban(@NonNull String bankIban) {
            this.parameters.put("bank_iban", bankIban);
            return this;
        }

        public CustomerRequestBuilder bankBic(@NonNull String bankBic) {
            this.parameters.put("bank_bic", bankBic);
            return this;
        }

        public CustomerRequestBuilder bankName(@NonNull String bankName) {
            this.parameters.put("bank_name", bankName);
            return this;
        }

        public CustomerRequestBuilder birthDate(@NonNull LocalDate birthDate) {
            this.parameters.put(
                    "birth_date",
                    birthDate.format(DateTimeFormatter.ISO_LOCAL_DATE)
                );
            return this;
        }

        public CustomerRequestBuilder cashAllowance(float cashAllowance) {
            this.parameters.put("cash_allowance", cashAllowance);
            return this;
        }

        public CustomerRequestBuilder cashAllowanceDays(int cashAllowanceDays) {
            this.parameters.put("cash_allowance_days", cashAllowanceDays);
            return this;
        }

        public CustomerRequestBuilder cashDiscount(float cashDiscount) {
            this.parameters.put("cash_discount", cashDiscount);
            return this;
        }

        public CustomerRequestBuilder cashDiscountType(
            DiscountType cashDiscountType
        ) {
            this.parameters.put("cash_discount_type", cashDiscountType);
            return this;
        }

        public CustomerRequestBuilder city(@NonNull String city) {
            this.parameters.put("city", city);
            return this;
        }

        public CustomerRequestBuilder state(@NonNull String state) {
            this.parameters.put("state", state);
            return this;
        }

        public CustomerRequestBuilder companyName(@NonNull String companyName) {
            this.parameters.put("company_name", companyName);
            return this;
        }

        public CustomerRequestBuilder country(@NonNull String country) {
            this.parameters.put("country", country);
            return this;
        }

        public CustomerRequestBuilder deliveryTitle(
            @NonNull String deliveryTitle
        ) {
            this.parameters.put("delivery_title", deliveryTitle);
            return this;
        }

        public CustomerRequestBuilder deliveryCity(
            @NonNull String deliveryCity
        ) {
            this.parameters.put("delivery_city", deliveryCity);
            return this;
        }

        public CustomerRequestBuilder deliveryState(
            @NonNull String deliveryState
        ) {
            this.parameters.put("delivery_state", deliveryState);
            return this;
        }

        public CustomerRequestBuilder deliveryCompanyName(
            @NonNull String deliveryCompanyName
        ) {
            this.parameters.put("delivery_company_name", deliveryCompanyName);
            return this;
        }

        public CustomerRequestBuilder deliveryCountry(
            @NonNull String deliveryCountry
        ) {
            this.parameters.put("delivery_country", deliveryCountry);
            return this;
        }

        public CustomerRequestBuilder deliveryFirstName(
            @NonNull String deliveryFirstName
        ) {
            this.parameters.put("delivery_first_name", deliveryFirstName);
            return this;
        }

        public CustomerRequestBuilder deliveryLastName(
            @NonNull String deliveryLastName
        ) {
            this.parameters.put("delivery_last_name", deliveryLastName);
            return this;
        }

        public CustomerRequestBuilder deliveryPersonal(
            boolean deliveryPersonal
        ) {
            this.parameters.put("delivery_personal", deliveryPersonal);
            return this;
        }

        public CustomerRequestBuilder deliverySalutation(
            @IntRange(from = 1, to = 6) int deliverySalutation
        ) {
            this.parameters.put("delivery_salutation", deliverySalutation);
            return this;
        }

        public CustomerRequestBuilder deliveryStreet(
            @NonNull String deliveryStreet
        ) {
            this.parameters.put("delivery_street", deliveryStreet);
            return this;
        }

        public CustomerRequestBuilder deliverySuffix1(
            @NonNull String deliverySuffix1
        ) {
            this.parameters.put("delivery_suffix_1", deliverySuffix1);
            return this;
        }

        public CustomerRequestBuilder deliverySuffix2(
            @NonNull String deliverySuffix2
        ) {
            this.parameters.put("delivery_suffix_2", deliverySuffix2);
            return this;
        }

        public CustomerRequestBuilder deliveryZipCode(
            @NonNull String deliveryZipCode
        ) {
            this.parameters.put("delivery_zip_code", deliveryZipCode);
            return this;
        }

        public CustomerRequestBuilder emails(List<@NonNull String> emails) {
            this.parameters.put("emails", emails);
            return this;
        }

        public CustomerRequestBuilder fax(@NonNull String fax) {
            this.parameters.put("fax", fax);
            return this;
        }

        public CustomerRequestBuilder firstName(@NonNull String firstName) {
            this.parameters.put("first_name", firstName);
            return this;
        }

        public CustomerRequestBuilder gracePeriod(int gracePeriod) {
            this.parameters.put("grace_period", gracePeriod);
            return this;
        }

        public CustomerRequestBuilder dueInDays(int dueInDays) {
            this.parameters.put("due_in_days", dueInDays);
            return this;
        }

        public CustomerRequestBuilder groupId(long groupId) {
            this.parameters.put("group_id", groupId);
            return this;
        }

        public CustomerRequestBuilder info1(@NonNull String info1) {
            this.parameters.put("info_1", info1);
            return this;
        }

        public CustomerRequestBuilder info2(@NonNull String info2) {
            this.parameters.put("info_2", info2);
            return this;
        }

        public CustomerRequestBuilder internet(@NonNull String internet) {
            this.parameters.put("internet", internet);
            return this;
        }

        public CustomerRequestBuilder lastName(@NonNull String lastName) {
            this.parameters.put("last_name", lastName);
            return this;
        }

        public CustomerRequestBuilder mobile(@NonNull String mobile) {
            this.parameters.put("mobile", mobile);
            return this;
        }

        public CustomerRequestBuilder note(@NonNull String note) {
            this.parameters.put("note", note);
            return this;
        }

        public CustomerRequestBuilder number(@NonNull String number) {
            this.parameters.put("number", number);
            return this;
        }

        public CustomerRequestBuilder paymentOptions(
            @IntRange(from = 1, to = 5) int paymentOptions
        ) {
            this.parameters.put("payment_options", paymentOptions);
            return this;
        }

        public CustomerRequestBuilder personal(boolean personal) {
            this.parameters.put("personal", personal);
            return this;
        }

        public CustomerRequestBuilder phone1(@NonNull String phone1) {
            this.parameters.put("phone_1", phone1);
            return this;
        }

        public CustomerRequestBuilder phone2(@NonNull String phone2) {
            this.parameters.put("phone_2", phone2);
            return this;
        }

        public CustomerRequestBuilder postbox(@NonNull String postbox) {
            this.parameters.put("postbox", postbox);
            return this;
        }

        public CustomerRequestBuilder postboxCity(@NonNull String postboxCity) {
            this.parameters.put("postbox_city", postboxCity);
            return this;
        }

        public CustomerRequestBuilder postboxState(
            @NonNull String postboxState
        ) {
            this.parameters.put("postbox_state", postboxState);
            return this;
        }

        public CustomerRequestBuilder postboxCountry(
            @NonNull String postboxCountry
        ) {
            this.parameters.put("postbox_country", postboxCountry);
            return this;
        }

        public CustomerRequestBuilder postboxZipCode(
            @NonNull String postboxZipCode
        ) {
            this.parameters.put("postbox_zip_code", postboxZipCode);
            return this;
        }

        public CustomerRequestBuilder salePriceLevel(
            @NonNull String salePriceLevel
        ) {
            this.parameters.put("sale_price_level", salePriceLevel);
            return this;
        }

        public CustomerRequestBuilder salutation(
            @IntRange(from = 1, to = 6) int salutation
        ) {
            this.parameters.put("salutation", salutation);
            return this;
        }

        public CustomerRequestBuilder sepa_agreement(
            @NonNull SepaAgreement sepaAgreement
        ) {
            this.parameters.put("sepa_agreement", sepaAgreement);
            return this;
        }

        public CustomerRequestBuilder sepaAgreementDate(
            @NonNull LocalDate sepaAgreementDate
        ) {
            this.parameters.put(
                    "sepa_agreement_date",
                    sepaAgreementDate.format(DateTimeFormatter.ISO_LOCAL_DATE)
                );
            return this;
        }

        public CustomerRequestBuilder sepaMandateReference(
            @NonNull String sepaMandateReference
        ) {
            this.parameters.put("sepa_mandate_reference", sepaMandateReference);
            return this;
        }

        public CustomerRequestBuilder sinceDate(@NonNull LocalDate sinceDate) {
            this.parameters.put(
                    "since_date",
                    sinceDate.format(DateTimeFormatter.ISO_LOCAL_DATE)
                );
            return this;
        }

        public CustomerRequestBuilder street(@NonNull String street) {
            this.parameters.put("street", street);
            return this;
        }

        public CustomerRequestBuilder suffix1(@NonNull String suffix1) {
            this.parameters.put("suffix_1", suffix1);
            return this;
        }

        public CustomerRequestBuilder suffix2(@NonNull String suffix2) {
            this.parameters.put("suffix_2", suffix2);
            return this;
        }

        public CustomerRequestBuilder taxNumber(@NonNull String taxNumber) {
            this.parameters.put("tax_number", taxNumber);
            return this;
        }

        public CustomerRequestBuilder court(@NonNull String court) {
            this.parameters.put("court", court);
            return this;
        }

        public CustomerRequestBuilder courtRegistryNumber(
            @NonNull String courtRegistryNumber
        ) {
            this.parameters.put("court_registry_number", courtRegistryNumber);
            return this;
        }

        public CustomerRequestBuilder vatOption(@Nullable VatOption vatOption) {
            this.parameters.put("tax_options", vatOption);
            return this;
        }

        public CustomerRequestBuilder title(@NonNull String title) {
            this.parameters.put("title", title);
            return this;
        }

        public CustomerRequestBuilder archived(boolean archived) {
            this.parameters.put("archived", archived);
            return this;
        }

        public CustomerRequestBuilder vatIdentifier(
            @NonNull String vatIdentifier
        ) {
            this.parameters.put("vat_identifier", vatIdentifier);
            return this;
        }

        public CustomerRequestBuilder zipCode(@NonNull String zipCode) {
            this.parameters.put("zip_code", zipCode);
            return this;
        }

        public CustomerRequestBuilder documentPdfType(
            @NonNull DocumentPdfType documentPdfType
        ) {
            this.parameters.put("document_pdf_type", documentPdfType);
            return this;
        }

        public CustomerRequestBuilder buyerReference(
            @NonNull String buyerReference
        ) {
            this.parameters.put("buyer_reference", buyerReference);
            return this;
        }

        public CustomerRequestBuilder foreignSupplierNumber(
            @NonNull String foreignSupplierNumber
        ) {
            this.parameters.put(
                    "foreign_supplier_number",
                    foreignSupplierNumber
                );
            return this;
        }
    }
}
