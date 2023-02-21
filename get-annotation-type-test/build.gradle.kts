plugins {
    id("java")
    kotlin("jvm")
    kotlin("kapt")
    id("com.google.devtools.ksp")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.google.devtools.ksp:symbol-processing-api:1.8.10-1.0.9")
    implementation(project(":annotation"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}