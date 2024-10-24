plugins {
    alias(libs.plugins.mkung.android.library)
    alias(libs.plugins.mkung.android.retrofit)
    alias(libs.plugins.mkung.android.hilt)
}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "com.appleroid.core.network"
}

dependencies {
    implementation(projects.core.common)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
}