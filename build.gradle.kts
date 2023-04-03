// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("io.github.janbarari.gradle-analytics-plugin") version "1.0.0-beta9"
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.android.gradle)
        classpath(libs.kotlin.gradle)
    }
}
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
