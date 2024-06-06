plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.jetbrains.compose)
}

group = "ie.stu.compose-window-capture-issue"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(libs.androidx.annotations)
}

compose.desktop {
    application {
        mainClass = "ie.stu.composewindowcaptureissue.MainKt"
    }
}