plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "me.mitul.portfolio"
    compileSdk = Config.compileSdkVersion
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Compose.compilerVersion

    defaultConfig {
        applicationId = "me.mitul.portfolio"
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }
}

dependencies {
    implementation(Lifecycle.livedataKtx)
    implementation(Compose.coil)
    implementation(Compose.ui)
    implementation(Compose.activity)
    implementation(Compose.material)
    implementation(Compose.foundation)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.constraintLayout)
    implementation(Compose.materialIconExtended)
    debugImplementation(Compose.uiTooling)
    debugImplementation(Compose.uiTestManifest)
    androidTestImplementation(Compose.uiTestJUnit4)

    testImplementation(Testing.jUnit)
    androidTestImplementation(Testing.espressoCore)
}
