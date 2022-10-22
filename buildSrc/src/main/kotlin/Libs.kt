object Versions {
    const val agpVersion = "7.3.1"
    const val kotlinVersion = "1.7.10"
}

object Testing {
    val jUnit by lazy { "junit:junit:4.13.2" }
    val extJUnit by lazy { "androidx.test.ext:junit:1.1.3" }
    val googleTruth by lazy { "com.google.truth:truth:1.1.3" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
}

object AndroidX {
    val coreKtx by lazy { "androidx.core:core-ktx:1.9.0" }
    val appcompat by lazy { "androidx.appcompat:appcompat:1.5.1" }
    val material by lazy { "com.google.android.material:material:1.6.1" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:2.1.4" }
}

object Lifecycle {
    private const val lifecycle = "2.5.1"
    val runtimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle" }
    val livedataKtx by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle" }
    val viewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle" }
    val viewModelCompose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle" }
    val viewModelSavedState by lazy { "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle" }
}

object Compose {
    private const val compose = "1.2.1"
    const val compilerVersion = "1.3.1"

    val ui by lazy { "androidx.compose.ui:ui:$compose" }
    val uiTooling by lazy { "androidx.compose.ui:ui-tooling:$compose" }
    val material by lazy { "androidx.compose.material:material:$compose" }
    val foundation by lazy { "androidx.compose.foundation:foundation:$compose" }
    val uiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:$compose" }
    val runtimeLivedata by lazy { "androidx.compose.runtime:runtime-livedata:$compose" }
    val foundationLayout by lazy { "androidx.compose.foundation:foundation-layout:$compose" }
    val materialIconExtended by lazy { "androidx.compose.material:material-icons-extended:$compose" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout-compose:1.0.1" }
    val uiTestJUnit4 by lazy { "androidx.compose.ui:ui-test-junit4:$compose" }
    val uiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:$compose" }

    val compiler by lazy { "androidx.compose.compiler:compiler:$compilerVersion" }
    val activity by lazy { "androidx.activity:activity-compose:1.5.1" }
    val coil by lazy { "io.coil-kt:coil-compose:2.1.0" }
}
