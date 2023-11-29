@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.arshapshap.paymentsapp.core.network"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        buildConfig = true
    }
    buildTypes {
        debug {
            buildConfigField("String", "BASE_API_URL", "\"https://easypay.world/api-test/\"")
            buildConfigField("String", "APP_KEY", "\"12345\"")
            buildConfigField("String", "API_VERSION", "\"1\"")
        }
        release {
            buildConfigField("String", "BASE_API_URL", "\"https://easypay.world/api-test/\"")
            buildConfigField("String", "APP_KEY", "\"12345\"")
            buildConfigField("String", "API_VERSION", "\"1\"")
        }
    }
}

dependencies {

    implementation(libs.koin)
    implementation(libs.okhttp)
    implementation(libs.androidx.security)

    api(libs.kotlinx.serialization.json)
    api(libs.retrofit.core)
    api(libs.retrofit.kotlinx.serialization)
}