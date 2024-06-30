import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import version.Koin
import version.Kotlin
import version.Ktor

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "2.0.0"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    val xcf = XCFramework()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            xcf.add(this)
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(Koin.core)
            implementation(Ktor.core)
            implementation(Ktor.serializationJson)
            implementation(Ktor.contentNegotiation)
            implementation(Kotlin.kotlinxCoroutinesCore)
            implementation(kotlin("reflect"))
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        androidMain.dependencies {
            implementation(Ktor.okHttp)
            implementation(Kotlin.kotlinxCoroutinesAndroid)
        }
        iosMain.dependencies {
            implementation(Ktor.darwin)
        }
    }
}

android {
    namespace = "com.walter.pokedata.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 23
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
