version = "1.0"

plugins {
    id("java-library")
    id("com.diffplug.spotless") version "6.20.0"
    id("com.github.spotbugs") version "5.1.0"
    id("org.checkerframework") version "0.6.30"
    id("io.freefair.lombok") version "8.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")
    implementation("org.javatuples:javatuples:1.2")

    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    compileOnly("org.checkerframework:checker-qual:3.36.0")
    testCompileOnly("org.checkerframework:checker-qual:3.36.0")
    checkerFramework("org.checkerframework:checker:3.36.0")
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