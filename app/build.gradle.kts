plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.glassboxdynatracebug"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.glassboxdynatracebug"
        minSdk = 33
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions.addAll(listOf("environment", "pinning"))

    productFlavors {
        //adding the version name suffix is now handled by fastlane
        val internal by creating {
            dimension = "environment"
            applicationIdSuffix = ".internal"
            isDefault = true
            /**
             * This token is used for Devtool APIs that only work on Flex.
             * This token rarely changes. If for any reason it stops working,
             * please contact QA to replace it.
             */
            buildConfigField("String", "DEVTOOLS_API_TOKEN", "\"dHN0c2V0dXA6TWNvNXJkcmZnZEt5ZXZSenJ3TzdzTmNMbllnMG1TaGtMaGhMWXQxRWd6Zz0=\"")
        }
        val insecure by creating {
            dimension = "pinning"
            isDefault = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.dynatrace)
    implementation(libs.glassbox)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}