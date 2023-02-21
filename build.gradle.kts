import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    kotlin("jvm") version "1.8.10"
    application
    id("com.google.devtools.ksp") version "1.8.10-1.0.9"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(project(":annotation"))
    ksp(project(":get-annotation-type-test"))
}

tasks.test {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


application {
    mainClass.set("MainKt")
}

allprojects {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap/")
        maven("https://www.jetbrains.com/intellij-repository/snapshots")
    }
}