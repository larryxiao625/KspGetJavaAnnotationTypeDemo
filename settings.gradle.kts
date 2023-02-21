pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap/")
        maven("https://www.jetbrains.com/intellij-repository/snapshots")
    }
}
rootProject.name = "KspTest"
include("get-annotation-type-test")
include("ksp")
include("annotation")
include("ksp-test")
