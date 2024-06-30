package version

object Ktor {
    private val version = "2.3.12"

    val core = "io.ktor:ktor-client-core:${version}"
    val okHttp = "io.ktor:ktor-client-okhttp:${version}"
    val darwin = "io.ktor:ktor-client-darwin:${version}"
    val serializationJson = "io.ktor:ktor-serialization-kotlinx-json:${version}"
    val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${version}"
}
