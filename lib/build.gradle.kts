version = "1.0"

plugins {
    id("java-library")
    id("com.diffplug.spotless") version "6.20.0"
    id("com.github.spotbugs") version "5.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(20))
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

