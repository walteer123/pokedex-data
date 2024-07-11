package version

object Compose {
    private val version = "1.9.23"
    private const val composeLiveDataVersion = "1.7.0-beta04"
    val composePlugin = "org.jetbrains.kotlin.plugin.compose:${version}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${composeLiveDataVersion}"
}