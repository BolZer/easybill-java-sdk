package io.github.bolzer.easybill_java_sdk;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.github.bolzer.easybill_java_sdk.contracts.HttpClient;
import io.github.bolzer.easybill_java_sdk.resources.*;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class Client {

    @NonNull
    public static final String USER_AGENT = "easybill-JAVA-REST-SDK-0.3.0";

    @NonNull
    @SuppressFBWarnings
    public static String BASE_URL = "https://api.easybill.de/rest/v1";

    @NonNull
    private final HttpClient httpClient;

    /** @param bearerToken the bearer token for authentication purpose*/
    public Client(@NonNull String bearerToken) {
        this.httpClient = new HttpClientImpl(bearerToken);
    }

    /** Returns an object that holds methods to interact with the document endpoint of the easybill REST API */
    public @NonNull DocumentResource getDocumentsResource() {
        return new DocumentResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the customer endpoint of the easybill REST API */
    public @NonNull CustomerResource getCustomerResource() {
        return new CustomerResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the position endpoint of the easybill REST API */
    public @NonNull PositionResource getPositionResource() {
        return new PositionResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the position group endpoint of the easybill REST API */
    public @NonNull PositionGroupResource getPositionGroupResource() {
        return new PositionGroupResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the customer group endpoint of the easybill REST API */
    public @NonNull CustomerGroupResource getCustomerGroupResource() {
        return new CustomerGroupResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the login endpoint of the easybill REST API*/
    public @NonNull LoginResource getLoginResource() {
        return new LoginResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the pdf template endpoint of the easybill REST API */
    public @NonNull PdfTemplateResource getPdfTemplateResource() {
        return new PdfTemplateResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the text template endpoint of the easybill REST API */
    public @NonNull TextTemplateResource getTextTemplateResource() {
        return new TextTemplateResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the document payment endpoint of the easybill REST API */
    public @NonNull DocumentPaymentResource getDocumentPaymentResource() {
        return new DocumentPaymentResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the postbox endpoint of the easybill REST API */
    public @NonNull PostBoxResource getPostBoxResource() {
        return new PostBoxResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the webhook endpoint of the easybill REST API */
    public @NonNull WebhookResource getWebhookResource() {
        return new WebhookResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the stock endpoint of the easybill REST API */
    public @NonNull StockResource getStockResource() {
        return new StockResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the serialnumber endpoint of the easybill REST API */
    public @NonNull SerialNumberResource getSerialNumberResource() {
        return new SerialNumberResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the sepa payment endpoint of the easybill REST API */
    public @NonNull SepaPaymentResource getSepaPaymentResource() {
        return new SepaPaymentResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the project endpoint of the easybill REST API */
    public @NonNull ProjectResource getProjectResource() {
        return new ProjectResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the time tracking endpoint of the easybill REST API */
    public @NonNull TimeTrackingResource getTimeTrackingResource() {
        return new TimeTrackingResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the discount endpoint of the easybill REST API */
    public @NonNull DiscountResource getDiscountResource() {
        return new DiscountResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the contact endpoint of the easybill REST API */
    public @NonNull ContactResource getContactResource() {
        return new ContactResource(this.httpClient);
    }

    /** Returns an object that holds methods to interact with the attachment endpoint of the easybill REST API */
    public @NonNull AttachmentResource getAttachmentResource() {
        return new AttachmentResource(this.httpClient);
    }
}
