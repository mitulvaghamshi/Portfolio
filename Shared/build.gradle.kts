plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
    kotlin("plugin.serialization").version(libs.versions.kotlin)
}

kotlin {
    // applyDefaultHierarchyTemplate()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach {
        it.binaries.framework {
            baseName = "Shared"
            // isStatic = true
        }
    }

    task("testClasses")

    sourceSets {
        commonMain.dependencies {
            // implementation(libs.kotlinx.datetime)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.content.negotiation)

            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.sqldelight.runtime)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.android)

            implementation(libs.sqldelight.android.driver)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)

            implementation(libs.sqldelight.native.driver)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "me.mitul.portfolio"
    compileSdk = 34
    defaultConfig {
        minSdk = 29
    }
}

sqldelight {
    linkSqlite = true
    databases {
        create(name = "RepoDatabase") {
            packageName.set("me.mitul.portfolio.cache")
        }
    }
}
