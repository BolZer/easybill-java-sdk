package com.github.bolzer.easybill_java_sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum WebhookEvent {
    DOCUMENT_CREATE("document.create"),

    DOCUMENT_UPDATE("document.update"),

    DOCUMENT_COMPLETED("document.completed"),

    DOCUMENT_DELETED("document.deleted"),

    DOCUMENT_PAYMENT_ADD("document.payment_add"),

    DOCUMENT_PAYMENT_DELETE("document.payment_delete"),

    CUSTOMER_CREATE("customer.create"),

    CUSTOMER_UPDATE("customer.update"),

    CUSTOMER_DELETE("customer.delete"),

    CONTACT_CREATE("contact.create"),

    CONTACT_UPDATE("contact.update"),

    CONTACT_DELETE("contact.delete"),

    POSITION_CREATE("position.create"),

    POSITION_UPDATE("position.update"),

    POSITION_DELETE("position.delete"),

    POSTBOX_CREATE("postbox.create"),

    POSTBOX_UPDATE("postbox.update"),

    POSTBOX_DELETE("postbox.delete"),

    POSTBOX_FAIL("postbox.fail"),

    POSTBOX_SENT("postbox.sent"),

    SEPA_PAYMENT_CREATE("sepa-payment.create"),

    SEPA_PAYMENT_UPDATE("sepa-payment.update"),

    SEPA_PAYMENT_EXPORTED("sepa-payment.exported"),

    SEPA_PAYMENT_DELETE("sepa-payment.delete"),

    TASK_CREATE("task.create"),

    TASK_UPDATE("task.update"),

    TASK_DELETE("task.delete"),

    PROJECT_CREATE("project.create"),

    PROJECT_UPDATE("project.update"),

    PROJECT_DELETE("project.delete");

    private String value;

    WebhookEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static WebhookEvent fromValue(String text) {
        for (WebhookEvent b : WebhookEvent.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new RuntimeException("Value for enum is invalid: " + text);
    }
}
