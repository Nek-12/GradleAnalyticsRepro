// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.versions)
//    alias(libs.plugins.version.catalog.update)
//    alias(libs.plugins.dependencyAnalysis)
    alias(libs.plugins.gradle.analytics)
//    alias(libs.plugins.detekt)
    kotlin("plugin.serialization") version libs.versions.kotlin.get() apply false
}


buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.android.gradle)
        classpath(libs.kotlin.gradle)
//        classpath(libs.version.gradle)
//        classpath(libs.google.gms)
//        classpath(libs.firebase.crashlytics.gradle)
//        classpath(libs.firebase.performance.gradle)
//        classpath(libs.detekt.gradle)
//        classpath(libs.sqldelight.gradle)
    }
}

//versionCatalogUpdate {
//    sortByKey.set(true)
//
//    keep {
//        keepUnusedVersions.set(true)
//        keepUnusedLibraries.set(true)
//        keepUnusedPlugins.set(true)
//    }
//}
//
//dependencyAnalysis {
//    issues {
//        all {
//            ignoreKtx(true)
//        }
//    }
//}


//dependencies {
//    detektPlugins(rootProject.libs.detekt.formatting)
//    detektPlugins(rootProject.libs.detekt.compose)
//}


gradleAnalyticsPlugin {

    database {
        local = sqlite {
            path = "${rootProject.rootDir}/scripts/analytics"
            name = "analytics"
        }
    }

    trackingTasks = setOf(
        "assembleRelease",
    )

    trackingBranches = setOf(
        "master",
    )

    // outputPath = "${rootProject.rootDir}/scripts/analytics"
}
