package io.github.bolzer.easybill_java_sdk.fixtures.pdf_templates;

import io.github.bolzer.easybill_java_sdk.fixtures.Fixture;
import okhttp3.mockwebserver.MockResponse;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class PdfTemplateFetchListFixture implements Fixture {

    public @NonNull String getRequestMethod() {
        return "GET";
    }

    public @NonNull String getRequestUrl() {
        return "/rest/v1/pdf-templates";
    }

    public @Nullable String getPostBody() {
        return null;
    }

    public @NonNull MockResponse getResponse() {
        String jsonResponse =
            """
                {
                   "items": [
                       {
                           "id": "INVOICE-DE",
                           "name": "Default template",
                           "pdf_template": "DE",
                           "document_type": "INVOICE",
                           "settings": {
                               "text_prefix": "%KUNDE.ANREDE%,\\nnachfolgend berechnen wir Ihnen wie vorab besprochen:\\n",
                               "text": "Vielen Dank für Ihren Auftrag!\\n\\nBitte begleichen Sie den offenen Betrag bis zum %DOKUMENT.DATUM-FAELLIG%.\\n\\nMit freundlichen Grüßen\\n\\n%FIRMA.FIRMA%\\n",
                               "email": {
                                   "subject": "Rechnung-%DOKUMENT.NUMMER%",
                                   "message": "%KUNDE.ANREDE%,\\n\\nanbei erhalten Sie Ihre Rechnung Nr. %DOKUMENT.NUMMER% vom %DOKUMENT.DATUM% im PDF-Format.\\nSie können die Rechnung auch unter der folgenden URL abrufen und ohne PDF-Reader anzeigen lassen:\\n\\n%DOKUMENT.LINK%\\n\\nMit freundlichen Grüßen\\n"
                               }
                           }
                       },
                       {
                           "id": "INVOICE-EN",
                           "name": "Default template (english)",
                           "pdf_template": "EN",
                           "document_type": "INVOICE",
                           "settings": {
                               "text_prefix": "Dear Sir or Madam,\\nbelow we will charge you as discussed previously:\\n",
                               "text": "Please remit the outstanding amount until  %DOCUMENT.DUE-DATE%.\\n",
                               "email": {
                                   "subject": "Invoice No. %DOCUMENT.NUMBER%",
                                   "message": "Dear Sir or Madam,\\n\\nplease find attached your invoice %DOCUMENT.NUMBER% from %DOCUMENT.DATE% as a PDF file. If you don’t have a PDF reader installed you can view the invoice at this URL:\\n\\n%DOCUMENT.LINK%\\n\\nBest regards\\n"
                               }
                           }
                       },
                       {
                           "id": "INVOICE-56309",
                           "name": "Rechnung mit Lieferanschrift",
                           "pdf_template": "56309",
                           "document_type": "INVOICE",
                           "settings": {
                               "text_prefix": "%KUNDE.ANREDE%,\\nnachfolgend berechnen wir Ihnen wie vorab besprochen:\\n",
                               "text": "Vielen Dank für Ihren Auftrag!\\n\\nBitte begleichen Sie den offenen Betrag bis zum %DOKUMENT.DATUM-FAELLIG%.\\n\\nMit freundlichen Grüßen\\n\\n%FIRMA.FIRMA%\\n",
                               "email": {
                                   "subject": "Rechnung-%DOKUMENT.NUMMER%",
                                   "message": "%KUNDE.ANREDE%,\\n\\nanbei erhalten Sie Ihre Rechnung Nr. %DOKUMENT.NUMMER% vom %DOKUMENT.DATUM% im PDF-Format.\\nSie können die Rechnung auch unter der folgenden URL abrufen und ohne PDF-Reader anzeigen lassen:\\n\\n%DOKUMENT.LINK%\\n\\nMit freundlichen Grüßen\\n"
                               }
                           }
                       }
                   ]
                }
                    """;

        return new MockResponse().setResponseCode(200).setBody(jsonResponse);
    }
}
