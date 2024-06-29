plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.mrshashankbisht.navigationcomponent"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mrshashankbisht.navigationcomponent"
        minSdk = 26
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Navigation Component
    // Java language implementation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    // Feature module Support
    implementation(libs.navigation.dynamic.features.fragment)
    // Testing Navigation
    androidTestImplementation(libs.navigation.testing)
    // Jetpack Compose Integration
    implementation(libs.navigation.compose)


    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}