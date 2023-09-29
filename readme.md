# easybill-java-sdk
[![Generic badge](https://img.shields.io/badge/Version-0.5.0-important.svg)]()
[![Generic badge](https://img.shields.io/badge/JDK-17-important.svg)]()


`easybill-java-sdk` is a library to work with the easybill REST API (https://www.easybill.de/api/) written in Java.

## Installation
This library is available on [Maven Central](https://central.sonatype.com/artifact/io.github.bolzer/easybill-java-sdk)

### Gradle

#### Kotlin DSL 
```
implementation("io.github.bolzer:easybill-java-sdk:0.5.0")
```

### Maven
```
<dependency>
    <groupId>io.github.bolzer</groupId>
    <artifactId>easybill-java-sdk</artifactId>
    <version>0.5.0</version>
</dependency>
```

## Motivation
It's easy to generate clients from OpenAPI documentations. However, those clients are often lacking in some areas.
This holds true in case of lacking / incorrect OpenAPI documentation. In the case of the easybill REST API the documentation
is such case. Therefore, a client generated from the documentation will have its issues. This project is an attempt to mitigate
the developer experience with the easybill REST API for JAVA developers.

## Examples
```java
package com.github.bolzer;

import io.github.bolzer.easybill_java_sdk.Client;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillRestException;
import io.github.bolzer.easybill_java_sdk.exceptions.EasybillTooManyRequestsException;
import io.github.bolzer.easybill_java_sdk.models.Document;
import io.github.bolzer.easybill_java_sdk.requests.DocumentListQueryRequest;
import io.github.bolzer.easybill_java_sdk.responses.PaginatedResponse;

import java.util.List;

public final class TestClass {
    void fetchDocumentsAndPrintIds() {
        Client client = new Client("BEARER_TOKEN");

        try {
            PaginatedResponse<Document> response = client
                    .getDocumentsResource()
                    .fetchDocuments(
                            DocumentListQueryRequest
                                    .builder()
                                    .page(2)
                                    .limit(10)
                                    .customerIds(List.of(
                                            2L,
                                            2345L,
                                            234112L
                                    ))
                                    .build()
                    );

            for (Document document : response.items()) {
                System.out.println(document.id());
            }
        } catch (EasybillTooManyRequestsException exception) {
            // REST API Limit exceeded
            // Response will include a header with the 
            // remaining time until you can make a request again
            int canTryAgainInSeconds = exception.getRetryAfterInSeconds();
        } catch (EasybillRestException easybillRestException) {
            // Generic Exception. Client and Server Exception will be caught.
        }
    }

}
```

Take a look at the tests directory. There are several testcases which may help you with basic usage of
the SDK.

## Roadmap
- Dedicated methods for invoice creation[^1].
- Adding the Versions Resource[^2]

[^1]: Currently there is only one method to create a document and the type of the document in the JSON-Payload will dictate which fields are required and which fields are relevant. As an example a document of the type LETTER won't have positions. 
[^2]: The resource versions is currently not included in the SDK as this resource is for a feature which is not yet available for the public.

## Issues
You have issues with the SDK: feature request, something is missing or simplify not correct, please be not afraid
to open up an issue here on github. There is currently no formalized way to open an issue, so just fire 
away.
