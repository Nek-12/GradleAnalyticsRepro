plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 33
    namespace = "com.nek12.analyticsrepro"

    defaultConfig {
        // TODO: May be important for repro
        buildToolsVersion = "33.0.0"
        applicationId = "com.nek12.analyticsrepro"
        targetSdk = 33
        minSdk = 26
        compileSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        aidl = false
        buildConfig = true
        prefab = false
        renderScript = false
        resValues = false
        shaders = false
        viewBinding = false
        compose = true
    }
//
//    applicationVariants.all {
//        outputs.all {
//            (this as com.android.build.gradle.internal.api.BaseVariantOutputImpl).outputFileName =
//                "$applicationId-$versionName.apk"
//        }
//
//        sourceSets {
//            getByName(name) {
//                kotlin.srcDir("build/generated/ksp/$name/kotlin")
//            }
//        }
//    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
        useLiveLiterals = true
    }

    // removes kotlinx.coroutines debug bins
    packaging {
        resources {
            excludes += setOf(
                "DebugProbesKt.bin",
                "/META-INF/{AL2.0,LGPL2.1}",
                "/META-INF/versions/9/previous-compilation-data.bin"
            )
        }
    }
}

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
            languageVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_1_9)
            freeCompilerArgs.addAll(listOf(
                "-Xjvm-default=all", // enable all jvm optimizations
                "-Xcontext-receivers",
                "-Xbackend-threads=0", // parallel IR compilation
            ))
        }
    }
}


dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}
