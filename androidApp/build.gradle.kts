plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlinx-serialization")
}

android {
    namespace = "com.zillow.zillowmobile.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.zillow.zillowmobile.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    val koinComposeVersion = "3.4.1"
    val navVersion = "2.5.3"

    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.activity:activity-compose:1.7.1")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    implementation("io.insert-koin:koin-androidx-compose:$koinComposeVersion")

    implementation("androidx.navigation:navigation-compose:$navVersion")

    //Glide
    implementation ("com.github.bumptech.glide:compose:1.0.0-alpha.1")

}