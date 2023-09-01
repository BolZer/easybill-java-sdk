package com.github.bolzer.easybill_java_sdk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.bolzer.easybill_java_sdk.enums.*;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public record Document(
    @JsonProperty("address") @NonNull DocumentAddress address,
    @JsonProperty("attachment_ids") List<@NonNull @Positive Long> attachmentIds,
    @JsonProperty("label_address") @NonNull DocumentAddress labelAddress,
    @JsonProperty("amount") long amount,
    @JsonProperty("amount_net") long amountNet,
    @JsonProperty("bank_debit_form") @Nullable String bankDebitForm,
    @JsonProperty("billing_country") @Nullable String billingCountry,
    @JsonProperty("calc_vat_from") int calcVatFrom,
    @JsonProperty("cancel_id") @Nullable Long cancelId,
    @JsonProperty("cash_allowance") @Nullable Float cashAllowance,
    @JsonProperty("cash_allowance_days") int cashAllowanceDays,
    @JsonProperty("cash_allowance_text") @Nullable String cashAllowanceText,
    @JsonProperty("contact_id") @Nullable Long contactId,
    @JsonProperty("contact_label") @Nullable String contactLabel,
    @JsonProperty("contact_text") @Nullable String contactText,
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NonNull
    LocalDateTime createdAt,
    @JsonProperty("currency") @NonNull String currency,
    @JsonProperty("customer_id") @Nullable Long customerId,
    @SuppressFBWarnings
    @JsonProperty("customer_snapshot")
    @Nullable
    Customer customerSnapshot,
    @JsonProperty("discount") @Nullable String discount,
    @JsonProperty("discount_type") @Nullable DiscountType discountType,
    @JsonProperty("document_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NonNull
    LocalDate documentDate,
    @JsonProperty("due_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Nullable
    LocalDate dueDate,
    @JsonProperty("edited_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime editedAt,
    @JsonProperty("external_id") String externalId,
    @JsonProperty("replica_url") String replicaUrl,
    @JsonProperty("grace_period") Integer gracePeriod,
    @JsonProperty("due_in_days") int dueInDays,
    @JsonProperty("id") @NonNull Long id,
    @JsonProperty("is_acceptable_on_public_domain")
    boolean isAcceptableOnPublicDomain,
    @JsonProperty("is_archive") boolean isArchive,
    @JsonProperty("is_draft") boolean isDraft,
    @JsonProperty("is_replica") boolean isReplica,
    @JsonProperty("is_cold") boolean isCold,
    @JsonProperty("is_oss") boolean isOss,
    @JsonProperty("coldstorage_due_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Nullable
    LocalDate coldstorageDueDate,
    @JsonProperty("item_notes") List<@NonNull String> itemNotes,
    @JsonProperty("items") List<@NonNull DocumentPosition> items,
    @JsonProperty("last_postbox_id") @Nullable Long lastPostboxId,
    @JsonProperty("login_id") @NonNull Long loginId,
    @JsonProperty("number") @Nullable String number,
    @JsonProperty("order_number") @NonNull String orderNumber,
    @JsonProperty("buyer_reference") @NonNull String buyerReference,
    @JsonProperty("paid_amount") long paidAmount,
    @JsonProperty("paid_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Nullable
    LocalDate paidAt,
    @JsonProperty("pdf_pages") int pdfPages,
    @JsonProperty("pdf_template") @NonNull String pdfTemplate,
    @JsonProperty("project_id") @Nullable Integer projectId,
    @JsonProperty("recurring_options")
    @Nullable
    DocumentRecurring recurringOptions,
    @JsonProperty("ref_id") @Nullable Long refId,
    @JsonProperty("root_id") @Nullable Long rootId,
    @JsonProperty("service_date") @NonNull ServiceDate serviceDate,
    @JsonProperty("shipping_country") @Nullable String shippingCountry,
    @JsonProperty("status") @Nullable Status status,
    @JsonProperty("text") @NonNull String text,
    @JsonProperty("text_prefix") @NonNull String textPrefix,
    @JsonProperty("text_tax") @Nullable String textTax,
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("type") @NonNull DocumentType type,
    @JsonProperty("use_shipping_address") boolean useShippingAddress,
    @JsonProperty("vat_country") @Nullable String vatCountry,
    @JsonProperty("vat_id") @Nullable String vatId,
    @JsonProperty("fulfillment_country") @Nullable String fulfillmentCountry,
    @JsonProperty("vat_option") @Nullable VatOption vatOption
) {
    public Document(
        @JsonProperty("address") @NonNull DocumentAddress address,
        @JsonProperty(
            "attachment_ids"
        ) List<@NonNull @Positive Long> attachmentIds,
        @JsonProperty("label_address") @NonNull DocumentAddress labelAddress,
        @JsonProperty("amount") long amount,
        @JsonProperty("amount_net") long amountNet,
        @JsonProperty("bank_debit_form") @Nullable String bankDebitForm,
        @JsonProperty("billing_country") @Nullable String billingCountry,
        @JsonProperty("calc_vat_from") int calcVatFrom,
        @JsonProperty("cancel_id") @Nullable Long cancelId,
        @JsonProperty("cash_allowance") @Nullable Float cashAllowance,
        @JsonProperty("cash_allowance_days") int cashAllowanceDays,
        @JsonProperty("cash_allowance_text") @Nullable String cashAllowanceText,
        @JsonProperty("contact_id") @Nullable Long contactId,
        @JsonProperty("contact_label") @Nullable String contactLabel,
        @JsonProperty("contact_text") @Nullable String contactText,
        @JsonProperty("created_at") @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
        ) @NonNull LocalDateTime createdAt,
        @JsonProperty("currency") @NonNull String currency,
        @JsonProperty("customer_id") @Nullable Long customerId,
        @JsonProperty("customer_snapshot") @Nullable Customer customerSnapshot,
        @JsonProperty("discount") @Nullable String discount,
        @JsonProperty("discount_type") @Nullable DiscountType discountType,
        @JsonProperty("document_date") @JsonFormat(
            pattern = "yyyy-MM-dd"
        ) @NonNull LocalDate documentDate,
        @JsonProperty("due_date") @JsonFormat(
            pattern = "yyyy-MM-dd"
        ) @Nullable LocalDate dueDate,
        @JsonProperty("edited_at") @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
        ) LocalDateTime editedAt,
        @JsonProperty("external_id") String externalId,
        @JsonProperty("replica_url") String replicaUrl,
        @JsonProperty("grace_period") Integer gracePeriod,
        @JsonProperty("due_in_days") int dueInDays,
        @JsonProperty("id") @NonNull Long id,
        @JsonProperty(
            "is_acceptable_on_public_domain"
        ) boolean isAcceptableOnPublicDomain,
        @JsonProperty("is_archive") boolean isArchive,
        @JsonProperty("is_draft") boolean isDraft,
        @JsonProperty("is_replica") boolean isReplica,
        @JsonProperty("is_cold") boolean isCold,
        @JsonProperty("is_oss") boolean isOss,
        @JsonProperty("coldstorage_due_date") @JsonFormat(
            pattern = "yyyy-MM-dd"
        ) @Nullable LocalDate coldstorageDueDate,
        @JsonProperty("item_notes") List<@NonNull String> itemNotes,
        @JsonProperty("items") List<@NonNull DocumentPosition> items,
        @JsonProperty("last_postbox_id") @Nullable Long lastPostboxId,
        @JsonProperty("login_id") @NonNull Long loginId,
        @JsonProperty("number") @Nullable String number,
        @JsonProperty("order_number") @NonNull String orderNumber,
        @JsonProperty("buyer_reference") @NonNull String buyerReference,
        @JsonProperty("paid_amount") long paidAmount,
        @JsonProperty("paid_at") @JsonFormat(
            pattern = "yyyy-MM-dd"
        ) @Nullable LocalDate paidAt,
        @JsonProperty("pdf_pages") int pdfPages,
        @JsonProperty("pdf_template") @NonNull String pdfTemplate,
        @JsonProperty("project_id") @Nullable Integer projectId,
        @JsonProperty(
            "recurring_options"
        ) @Nullable DocumentRecurring recurringOptions,
        @JsonProperty("ref_id") @Nullable Long refId,
        @JsonProperty("root_id") @Nullable Long rootId,
        @JsonProperty("service_date") @NonNull ServiceDate serviceDate,
        @JsonProperty("shipping_country") @Nullable String shippingCountry,
        @JsonProperty("status") @Nullable Status status,
        @JsonProperty("text") @NonNull String text,
        @JsonProperty("text_prefix") @NonNull String textPrefix,
        @JsonProperty("text_tax") @Nullable String textTax,
        @JsonProperty("title") @Nullable String title,
        @JsonProperty("type") @NonNull DocumentType type,
        @JsonProperty("use_shipping_address") boolean useShippingAddress,
        @JsonProperty("vat_country") @Nullable String vatCountry,
        @JsonProperty("vat_id") @Nullable String vatId,
        @JsonProperty(
            "fulfillment_country"
        ) @Nullable String fulfillmentCountry,
        @JsonProperty("vat_option") @Nullable VatOption vatOption
    ) {
        this.address = address;
        this.attachmentIds = Collections.unmodifiableList(attachmentIds);
        this.labelAddress = labelAddress;
        this.amount = amount;
        this.amountNet = amountNet;
        this.bankDebitForm = bankDebitForm;
        this.billingCountry = billingCountry;
        this.calcVatFrom = calcVatFrom;
        this.cancelId = cancelId;
        this.cashAllowance = cashAllowance;
        this.cashAllowanceDays = cashAllowanceDays;
        this.cashAllowanceText = cashAllowanceText;
        this.contactId = contactId;
        this.contactLabel = contactLabel;
        this.contactText = contactText;
        this.createdAt = createdAt;
        this.currency = currency;
        this.customerId = customerId;
        this.customerSnapshot = customerSnapshot;
        this.discount = discount;
        this.discountType = discountType;
        this.documentDate = documentDate;
        this.dueDate = dueDate;
        this.editedAt = editedAt;
        this.externalId = externalId;
        this.replicaUrl = replicaUrl;
        this.gracePeriod = gracePeriod;
        this.dueInDays = dueInDays;
        this.id = id;
        this.isAcceptableOnPublicDomain = isAcceptableOnPublicDomain;
        this.isArchive = isArchive;
        this.isDraft = isDraft;
        this.isReplica = isReplica;
        this.isCold = isCold;
        this.isOss = isOss;
        this.coldstorageDueDate = coldstorageDueDate;
        this.itemNotes = Collections.unmodifiableList(itemNotes);
        this.items = Collections.unmodifiableList(items);
        this.lastPostboxId = lastPostboxId;
        this.loginId = loginId;
        this.number = number;
        this.orderNumber = orderNumber;
        this.buyerReference = buyerReference;
        this.paidAmount = paidAmount;
        this.paidAt = paidAt;
        this.pdfPages = pdfPages;
        this.pdfTemplate = pdfTemplate;
        this.projectId = projectId;
        this.recurringOptions = recurringOptions;
        this.refId = refId;
        this.rootId = rootId;
        this.serviceDate = serviceDate;
        this.shippingCountry = shippingCountry;
        this.status = status;
        this.text = text;
        this.textPrefix = textPrefix;
        this.textTax = textTax;
        this.title = title;
        this.type = type;
        this.useShippingAddress = useShippingAddress;
        this.vatCountry = vatCountry;
        this.vatId = vatId;
        this.fulfillmentCountry = fulfillmentCountry;
        this.vatOption = vatOption;
    }

    public record DocumentAddress(
        @JsonProperty("salutation") int salutation,
        @JsonProperty("personal") boolean personal,
        @JsonProperty("title") @Nullable String title,
        @JsonProperty("first_name") @NonNull String firstName,
        @JsonProperty("last_name") @NonNull String lastName,
        @JsonProperty("suffix_1") @Nullable String suffix1,
        @JsonProperty("suffix_2") @Nullable String suffix2,
        @JsonProperty("company_name") @NonNull String companyName,
        @JsonProperty("street") @NonNull String street,
        @JsonProperty("zip_code") @NonNull String zipCode,
        @JsonProperty("city") @NonNull String city,
        @JsonProperty("state") @NonNull String state,
        @JsonProperty("country") @NonNull String country
    ) {}

    public record DocumentPosition(
        @JsonProperty("number") @Nullable String number,
        @JsonProperty("description") @Nullable String description,
        @JsonProperty("document_note") @NonNull String documentNote,
        @JsonProperty("quantity") @NonNull Float quantity,
        @JsonProperty("quantity_str") @Nullable String quantityStr,
        @JsonProperty("unit") @Nullable String unit,
        @JsonProperty("type") @NonNull PositionType type,
        @JsonProperty("position") int position,
        @JsonProperty("single_price_net") @Nullable Float singlePriceNet,
        @JsonProperty("single_price_gross") @Nullable Float singlePriceGross,
        @JsonProperty("vat_percent") @Nullable Float vatPercent,
        @JsonProperty("discount") @Nullable Float discount,
        @JsonProperty("discount_type") @Nullable DiscountType discountType,
        @JsonProperty("position_id") @Nullable Long positionId,
        @JsonProperty("total_price_net") @Nullable Float totalPriceNet,
        @JsonProperty("total_price_gross") @Nullable Float totalPriceGross,
        @JsonProperty("total_vat") @Nullable Float totalVat,
        @JsonProperty("serial_number_id") @Nullable String serialNumberId,
        @JsonProperty("serial_number") @Nullable String serialNumber,
        @JsonProperty("booking_account") @Nullable String bookingAccount,
        @JsonProperty("export_cost_1") @Nullable String exportCost1,
        @JsonProperty("export_cost_2") @Nullable String exportCost2,
        @JsonProperty("cost_price_net") @Nullable Float costPriceNet,
        @JsonProperty("cost_price_total") @Nullable Float costPriceTotal,
        @JsonProperty("cost_price_charge") @Nullable Float costPriceCharge,
        @JsonProperty("cost_price_charge_type")
        @Nullable
        CostPriceChargeType costPriceChargeType,
        @JsonProperty("item_type") @NonNull ItemType itemType,
        @JsonProperty("id") long id
    ) {}

    public record DocumentRecurring(
        @JsonProperty("next_date")
        @JsonFormat(pattern = "yyyy-MM-dd")
        @Nullable
        LocalDate nextDate,
        @JsonProperty("frequency") @NonNull RecurringFrequency frequency,
        @JsonProperty("frequency_special")
        @NonNull
        RecurringFrequencySpecial frequencySpecial,
        @JsonProperty("interval") int interval,
        @JsonProperty("end_date_or_count") @Nullable String endDateOrCount,
        @JsonProperty("status") @NonNull RecurringStatus status,
        @JsonProperty("as_draft") boolean asDraft,
        @JsonProperty("is_notify") boolean isNotify,
        @JsonProperty("send_as") @Nullable DocumentSendType sendAs,
        @JsonProperty("is_sign") boolean isSign,
        @JsonProperty("is_paid") boolean isPaid,
        @JsonProperty("paid_date_option")
        @NonNull
        RecurringPaidDateOption paidDateOption,
        @JsonProperty("is_sepa") boolean isSepa,

        @JsonProperty("sepa_local_instrument")
        @NonNull
        SepaLocalInstrumentType sepaLocalInstrument,
        @JsonProperty("sepa_sequence_type")
        @NonNull
        SepaSequenceType sepaSequenceType,
        @JsonProperty("sepa_reference") @NonNull String sepaReference,
        @JsonProperty("sepa_remittance_information")
        @NonNull
        String sepaRemittanceInformation,
        @JsonProperty("target_type")
        @NonNull
        RecurringTargetDocumentType targetType
    ) {}
}
