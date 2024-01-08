// Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
}

application {
    // Define the main class for the application.
    mainClass.set("jeuvingtetun.Main")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.named<JavaCompile>("compileJava") {
    javaCompiler.set(javaToolchains.compilerFor {
        languageVersion.set(JavaLanguageVersion.of(21))
    })
}

tasks.named<JavaExec>("run") {
    setStandardInput(System.`in`)
}

tasks.named<Test>("test") {
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(21))
    })
    useJUnitPlatform()
}

tasks.named<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = "jeuvingtetun.Main"
    }
}
