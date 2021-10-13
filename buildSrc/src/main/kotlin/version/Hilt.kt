package version

object Hilt {
    private const val daggerHiltVersion = "2.39"
    private const val hiltVersion = "1.0.0"

    const val daggerHiltAndroid = "com.google.dagger:hilt-android:$daggerHiltVersion"
    const val common = "androidx.hilt:hilt-common:$hiltVersion"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"

    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$daggerHiltVersion"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:$hiltVersion"

    object Test {
        const val androidTesting = "com.google.dagger:hilt-android-testing:$daggerHiltVersion"
        const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:$daggerHiltVersion"
    }
}
