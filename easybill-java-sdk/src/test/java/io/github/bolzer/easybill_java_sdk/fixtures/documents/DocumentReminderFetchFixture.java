package io.github.bolzer.easybill_java_sdk.fixtures.documents;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class DocumentReminderFetchFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/documents/2577328538";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                    "address": {
                        "city": "Kaarst",
                        "company_name": "easybill GmbH",
                        "country": "DE",
                        "first_name": "Max",
                        "last_name": "Mustermann",
                        "personal": false,
                        "salutation": 1,
                        "state": "",
                        "street": "Düsselstr. 21",
                        "suffix_1": null,
                        "suffix_2": null,
                        "title": null,
                        "zip_code": "41564"
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
                    "number": "Something",
                    "pdf_pages": 0,
                    "pdf_template": "DE",
                    "ref_id": 2566753438,
                    "text": "%kunde.anrede%,<br><br>bis zum heutigen Tage wurde die Rechnung Nr. %refdokument.nummer% vom %refdokument.datum% und einem Zahlbetrag i. H. v. %refdokument.betrag% nicht beglichen. Die Zahlung war bereits am %refdokument.datum-faellig% f&auml;llig!<br><br>Wir m&ouml;chten Sie daher bitten, dies innerhalb der n&auml;chsten 7 Tage durch &Uuml;berweisung an die unten genannte Bankverbindung nachzuholen.<br><br>Falls Sie Fragen zur Rechnung haben oder Wir Ihnen in einer anderen Sache weiterhelfen d&uuml;rfen, k&ouml;nnen Sie gerne Kontakt mit uns aufnehmen.<br><br>Sollte sich Ihre mittlerweile erfolgte Zahlung und diese Mahnung &uuml;berschnitten haben, bitten wir Sie dieses zu ignorieren.<br><br>Mit freundlichen Gr&uuml;&szlig;en<br><br>%firma.firma%",
                    "text_prefix": "<br>",
                    "title": null,
                    "type": "REMINDER"
                }
            """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
