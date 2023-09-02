# easybill-java-sdk
[![Generic badge](https://img.shields.io/badge/Version-0.1.0-important.svg)]()

`easybill-java-sdk` is a library to work with the easybill REST API (https://www.easybill.de/api/) written in Java.

### *Active Developing ongoing!*

## Installation
This library is available on [Maven Central](https://central.sonatype.com/artifact/io.github.bolzer/easybill-java-sdk)

### Gradle

#### Kotlin DSL 
```
implementation("io.github.bolzer:easybill-java-sdk:0.1")
```

### Maven
```
<dependency>
    <groupId>io.github.bolzer</groupId>
    <artifactId>easybill-java-sdk</artifactId>
    <version>0.1</version>
</dependency>
```

## Motivation
*coming soon*

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


*more coming soon* 

## Roadmap
*coming soon*

## Issues
*coming soon* 

## Contributions
*coming soon* 