plugins {
    id("com.android.application").version(Versions.agpVersion).apply(false)
    kotlin("android").version(Versions.kotlinVersion).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
