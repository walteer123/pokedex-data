package version

object Kotlin {
    private const val coroutinesVersion = "1.8.1"

    val kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}"
    val kotlinxCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${coroutinesVersion}"
}