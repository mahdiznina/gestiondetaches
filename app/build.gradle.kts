plugins {
    alias(libs.plugins.android.application) // استخدم هذه فقط
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("kapt") // تأكد من إضافة هذا السطر لتفعيل Kapt (لـ Room)
    id("com.google.gms.google-services") version "4.4.2" apply false //firebase
}

android {
    namespace = "com.example.gestiondetaches"  // قم بتحديد الـ namespace هنا

    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.gestiondetaches"  // نفس اسم الـ namespace
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
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

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    // التبعيات الخاصة بـ Room
    implementation("androidx.room:room-runtime:2.5.2") // Room Database
    kapt("androidx.room:room-compiler:2.5.2") // Kapt لتوليد الكود تلقائيًا
    implementation(platform("com.google.firebase:firebase-bom:33.6.0")) //firebase
    implementation("com.google.firebase:firebase-analytics") //firebase

    // تبعيات أخرى مثل Compose و Navigation
    implementation("androidx.navigation:navigation-compose:2.7.2")
    implementation("androidx.compose.foundation:foundation:1.5.1")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.runtime:runtime-saveable:1.5.1")
    implementation("androidx.compose.ui:ui:1.5.1")
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("androidx.datastore:datastore:1.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    // تبعيات أخرى مثل UI و Tests
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)

    // تبعيات الاختبارات
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
