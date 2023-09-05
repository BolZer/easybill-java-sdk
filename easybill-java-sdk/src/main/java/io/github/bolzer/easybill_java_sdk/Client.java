package io.github.bolzer.easybill_java_sdk;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.resources.*;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class Client {

    @NonNull
    public static final String USER_AGENT = "easybill-JAVA-REST-SDK-0.2.1";

    @NonNull
    @SuppressFBWarnings
    public static String BASE_URL = "https://api.easybill.de/rest/v1";

    @NonNull
    private final HttpClient httpClient;

    public Client(@NonNull String bearerToken) {
        this.httpClient = new HttpClientWrapper(bearerToken);
    }

    public @NonNull DocumentResource getDocumentsResource() {
        return new DocumentResource(this.httpClient);
    }

    public @NonNull CustomerResource getCustomerResource() {
        return new CustomerResource(this.httpClient);
    }

    public @NonNull PositionResource getPositionResource() {
        return new PositionResource(this.httpClient);
    }

    public @NonNull PositionGroupResource getPositionGroupResource() {
        return new PositionGroupResource(this.httpClient);
    }

    public @NonNull CustomerGroupResource getCustomerGroupResource() {
        return new CustomerGroupResource(this.httpClient);
    }

    public @NonNull LoginResource getLoginResource() {
        return new LoginResource(this.httpClient);
    }

    public @NonNull PdfTemplateResource getPdfTemplateResource() {
        return new PdfTemplateResource(this.httpClient);
    }

    public @NonNull TextTemplateResource getTextTemplateResource() {
        return new TextTemplateResource(this.httpClient);
    }

    public @NonNull DocumentPaymentResource getDocumentPaymentResource() {
        return new DocumentPaymentResource(this.httpClient);
    }

    public @NonNull PostBoxResource getPostBoxResource() {
        return new PostBoxResource(this.httpClient);
    }

    public @NonNull WebhookResource getWebhookResource() {
        return new WebhookResource(this.httpClient);
    }

    public @NonNull StockResource getStockResource() {
        return new StockResource(this.httpClient);
    }

    public @NonNull SerialNumberResource getSerialNumberResource() {
        return new SerialNumberResource(this.httpClient);
    }

    public @NonNull SepaPaymentResource getSepaPaymentResource() {
        return new SepaPaymentResource(this.httpClient);
    }

    public @NonNull ProjectResource getProjectResource() {
        return new ProjectResource(this.httpClient);
    }

    public @NonNull TimeTrackingResource getTimeTrackingResource() {
        return new TimeTrackingResource(this.httpClient);
    }

    public @NonNull DiscountResource getDiscountResource() {
        return new DiscountResource(this.httpClient);
    }

    public @NonNull ContactResource getContactResource() {
        return new ContactResource(this.httpClient);
    }

    public @NonNull AttachmentResource getAttachmentResource() {
        return new AttachmentResource(this.httpClient);
    }
}
