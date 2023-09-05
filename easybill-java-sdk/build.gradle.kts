import java.net.URI

version = "0.2.0"

java {
    withJavadocJar()
    withSourcesJar()
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

plugins {
    id("java-library")
    id("maven-publish")
    id("signing")
    id("com.diffplug.spotless") version "6.20.0"
    id("com.github.spotbugs") version "5.1.0"
    id("org.checkerframework") version "0.6.30"
    id("io.freefair.lombok") version "8.1.0"
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")
    implementation("org.javatuples:javatuples:1.2")

    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    compileOnly("org.checkerframework:checker-qual:3.36.0")
    testCompileOnly("org.checkerframework:checker-qual:3.36.0")
    checkerFramework("org.checkerframework:checker:3.36.0")
}

tasks{
    javadoc{
        title = rootProject.name + " " + version + " " + "API"
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.github.bolzer"
            artifactId = "easybill-java-sdk"
            version = "0.2.0"

            from(components["java"])

            pom {
                name.set("easybill-java-sdk")
                description.set("A SDK to work with the easybill REST API")
                url.set("https://github.com/BolZer/easybill-java-sdk")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("BolZer")
                        name.set("Jan Nöhles")
                        email.set("noehles.jan@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/BolZer/easybill-java-sdk.git")
                    developerConnection.set("scm:git:ssh://github.com/BolZer/easybill-java-sdk.git")
                    url.set("https://github.com/BolZer/easybill-java-sdk")
                }
            }
        }

        signing{
            val gpgSigningKey = System.getenv("GPG_SIGNING_KEY")
            val gpgSigningPassword = System.getenv("GPG_SIGNING_PASSWORD")
            useInMemoryPgpKeys(gpgSigningKey, gpgSigningPassword)
            sign(publishing.publications["maven"])
        }
    }

    repositories{
        maven {
            name = "OSSRH"
            url = URI("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = System.getenv("OSSRH_USERNAME")
                password = System.getenv("OSSRH_PASSWORD")
            }
        }
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes(mapOf(
            "Implementation-Title" to project.name,
            "Implementation-Version" to project.version
        ))
    }
}

spotbugs {
    ignoreFailures = false
    showProgress = false
}

spotless {
    java {
        importOrder()
        prettier(mapOf(
            "prettier" to "2.8.8",
            "prettier-plugin-java" to "2.2.0"
        )).config(mapOf(
            "parser" to "java",
            "tabWidth" to 4,
        ))
        removeUnusedImports()
    }
}

checkerFramework {
    excludeTests = true
    suppressLombokWarnings = false
    checkers = listOf(
        "org.checkerframework.checker.nullness.NullnessChecker",
        "org.checkerframework.checker.units.UnitsChecker",
        "org.checkerframework.checker.interning.InterningChecker",
        "org.checkerframework.checker.index.IndexChecker",
        "org.checkerframework.checker.calledmethods.CalledMethodsChecker",
        "org.checkerframework.checker.resourceleak.ResourceLeakChecker",
        "org.checkerframework.checker.tainting.TaintingChecker",
        "org.checkerframework.checker.formatter.FormatterChecker",
        "org.checkerframework.checker.propkey.PropertyKeyChecker",
        "org.checkerframework.framework.util.PurityChecker",
        "org.checkerframework.common.value.ValueChecker",
    )
    extraJavacArgs = listOf(
        "-AsuppressWarnings=type.anno.before.decl.anno,type.anno.before.modifier"
    )
}