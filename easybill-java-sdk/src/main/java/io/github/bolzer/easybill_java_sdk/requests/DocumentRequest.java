package io.github.bolzer.easybill_java_sdk.requests;

import com.fasterxml.jackson.annotation.JsonValue;
import io.github.bolzer.easybill_java_sdk.enums.BankDebitForm;
import io.github.bolzer.easybill_java_sdk.enums.DiscountType;
import io.github.bolzer.easybill_java_sdk.enums.DocumentType;
import io.github.bolzer.easybill_java_sdk.enums.VatOption;
import io.github.bolzer.easybill_java_sdk.models.ServiceDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentRequest {

    @JsonValue
    public final Map<@NonNull String, @Nullable Object> parameters;

    private DocumentRequest(
        @NonNull Map<@NonNull String, @Nullable Object> parameters
    ) {
        this.parameters = parameters;
    }

    public static DocumentRequestBuilder builder() {
        return new DocumentRequestBuilder();
    }

    public static class DocumentRequestBuilder {

        private final Map<@NonNull String, @Nullable Object> parameters =
            new HashMap<>();

        public DocumentRequest build() {
            return new DocumentRequest(this.parameters);
        }

        public DocumentRequestBuilder documentDate(
            @NonNull LocalDate documentDate
        ) {
            this.parameters.put(
                    "document_date",
                    documentDate.format(DateTimeFormatter.ISO_LOCAL_DATE)
                );
            return this;
        }

        public DocumentRequestBuilder number(@Nullable String number) {
            this.parameters.put("number", number);
            return this;
        }

        public DocumentRequestBuilder text(@Nullable String text) {
            this.parameters.put("text", text);
            return this;
        }

        public DocumentRequestBuilder textPrefix(@Nullable String text) {
            this.parameters.put("text_prefix", text);
            return this;
        }

        public DocumentRequestBuilder textTax(@Nullable String text) {
            this.parameters.put("text_tax", text);
            return this;
        }

        public DocumentRequestBuilder type(@NonNull DocumentType type) {
            this.parameters.put("type", type);
            return this;
        }

        public DocumentRequestBuilder title(@Nullable String title) {
            this.parameters.put("title", title);
            return this;
        }

        public DocumentRequestBuilder buyerReference(
            @NonNull String buyerReference
        ) {
            this.parameters.put("buyer_reference", buyerReference);
            return this;
        }

        public DocumentRequestBuilder status(@Nullable String status) {
            this.parameters.put("status", status);
            return this;
        }

        public DocumentRequestBuilder vatOption(@Nullable VatOption vatOption) {
            this.parameters.put("vat_option", vatOption);
            return this;
        }

        public DocumentRequestBuilder pdfTemplate(
            @Nullable String pdfTemplate
        ) {
            this.parameters.put("pdf_template", pdfTemplate);
            return this;
        }

        public DocumentRequestBuilder loginId(@Nullable Long loginId) {
            this.parameters.put("login_id", loginId);
            return this;
        }

        public DocumentRequestBuilder customerId(@Nullable Long customerId) {
            this.parameters.put("customer_id", customerId);
            return this;
        }

        public DocumentRequestBuilder refId(@Nullable Long refId) {
            this.parameters.put("ref_id", refId);
            return this;
        }

        public DocumentRequestBuilder projectId(@Nullable Long projectId) {
            this.parameters.put("project_id", projectId);
            return this;
        }

        public DocumentRequestBuilder contactId(@Nullable Long contactId) {
            this.parameters.put("contact_id", contactId);
            return this;
        }

        public DocumentRequestBuilder useShippingCountry(
            @NonNull Boolean useShippingCountry
        ) {
            this.parameters.put("use_shipping_address", useShippingCountry);
            return this;
        }

        public DocumentRequestBuilder shippingCountry(
            @Nullable String shippingCountry
        ) {
            this.parameters.put("shipping_country", shippingCountry);
            return this;
        }

        public DocumentRequestBuilder billingCountry(
            @Nullable String billingCountry
        ) {
            this.parameters.put("billing_country", billingCountry);
            return this;
        }

        public DocumentRequestBuilder vatCountry(@Nullable String vatCountry) {
            this.parameters.put("vat_country", vatCountry);
            return this;
        }

        public DocumentRequestBuilder fulfillmentCountry(
            @Nullable String fulfillmentCountry
        ) {
            this.parameters.put("fulfillment_country", fulfillmentCountry);
            return this;
        }

        public DocumentRequestBuilder items(
            @NonNull List<DocumentPositionRequest> items
        ) {
            this.parameters.put("items", items);
            return this;
        }

        public DocumentRequestBuilder isArchive(boolean isArchive) {
            this.parameters.put("is_archive", isArchive);
            return this;
        }

        public DocumentRequestBuilder isReplica(boolean isReplica) {
            this.parameters.put("is_replica", isReplica);
            return this;
        }

        public DocumentRequestBuilder isOss(boolean isOss) {
            this.parameters.put("is_oss", isOss);
            return this;
        }

        public DocumentRequestBuilder isAcceptableOnPublicDomain(
            boolean isAcceptableOnPublicDomain
        ) {
            this.parameters.put(
                    "is_acceptable_on_public_domain",
                    isAcceptableOnPublicDomain
                );
            return this;
        }

        public DocumentRequestBuilder replicaUrl(@Nullable String replicaUrl) {
            this.parameters.put("replica_url", replicaUrl);
            return this;
        }

        public DocumentRequestBuilder externalId(@Nullable Long externalId) {
            this.parameters.put("external_id", externalId);
            return this;
        }

        public DocumentRequestBuilder currency(@NonNull String currency) {
            this.parameters.put("currency", currency);
            return this;
        }

        public DocumentRequestBuilder discountType(
            @NonNull DiscountType discountType
        ) {
            this.parameters.put("discount_type", discountType);
            return this;
        }

        public DocumentRequestBuilder discount(@Nullable String discount) {
            this.parameters.put("discount", discount);
            return this;
        }

        public DocumentRequestBuilder calcVatFrom(int calcVatFrom) {
            this.parameters.put("calc_vat_from", calcVatFrom);
            return this;
        }

        public DocumentRequestBuilder dueInDays(int dueInDays) {
            this.parameters.put("due_in_days", dueInDays);
            return this;
        }

        public DocumentRequestBuilder bankDebitForm(
            @Nullable BankDebitForm bankDebitForm
        ) {
            this.parameters.put("bank_debit_form", bankDebitForm);
            return this;
        }

        public DocumentRequestBuilder attachmentIds(
            @NonNull List<@NonNull Long> attachmentIds
        ) {
            this.parameters.put("attachment_ids", attachmentIds);
            return this;
        }

        public DocumentRequestBuilder serviceDate(
            @NonNull ServiceDate serviceDate
        ) {
            this.parameters.put("service_date", serviceDate);
            return this;
        }
    }
}
