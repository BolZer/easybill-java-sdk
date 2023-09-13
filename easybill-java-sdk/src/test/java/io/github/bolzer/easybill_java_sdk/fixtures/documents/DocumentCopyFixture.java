package io.github.bolzer.easybill_java_sdk.fixtures.documents;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import io.github.bolzer.easybill_java_sdk.requests.DocumentRequest;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentCopyFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "POST";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/documents/139/REMINDER";
    }

    public @Nullable Object getPostBody() {
        return DocumentRequest
            .builder()
            .number("Reminder for your Payment")
            .build();
    }

    public @NonNull MockResponse getResponse() {
        var body =
            """
                {
                      "address": {
                          "city": "",
                          "company_name": "",
                          "country": "",
                          "first_name": "",
                          "last_name": "",
                          "personal": false,
                          "salutation": 0,
                          "state": "",
                          "street": "",
                          "suffix_1": "",
                          "suffix_2": "",
                          "title": "",
                          "zip_code": ""
                      },
                      "bank_debit_form": null,
                      "contact_id": null,
                      "contact_label": null,
                      "contact_text": null,
                      "created_at": "2023-09-13 04:23:16",
                      "customer_id": 356069442,
                      "document_date": "2023-09-13",
                      "edited_at": "2023-09-13 04:23:16",
                      "id": 2577328538,
                      "is_draft": true,
                      "number": "Reminder for your Payment",
                      "pdf_pages": 0,
                      "pdf_template": "DE",
                      "ref_id": 139,
                      "text": "%kunde.anrede%,<br><br>bis zum heutigen Tage wurde die Rechnung Nr. %refdokument.nummer% vom %refdokument.datum% und einem Zahlbetrag i. H. v. %refdokument.betrag% nicht beglichen. Die Zahlung war bereits am %refdokument.datum-faellig% f&auml;llig!<br><br>Wir m&ouml;chten Sie daher bitten, dies innerhalb der n&auml;chsten 7 Tage durch &Uuml;berweisung an die unten genannte Bankverbindung nachzuholen.<br><br>Falls Sie Fragen zur Rechnung haben oder Wir Ihnen in einer anderen Sache weiterhelfen d&uuml;rfen, k&ouml;nnen Sie gerne Kontakt mit uns aufnehmen.<br><br>Sollte sich Ihre mittlerweile erfolgte Zahlung und diese Mahnung &uuml;berschnitten haben, bitten wir Sie dieses zu ignorieren.<br><br>Mit freundlichen Gr&uuml;&szlig;en<br><br>%firma.firma%",
                      "text_prefix": "<br>",
                      "title": null,
                      "type": "REMINDER"
                }
                """;

        return new MockResponse().setResponseCode(201).setBody(body);
    }
}
