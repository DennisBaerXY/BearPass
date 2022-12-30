val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

val koin_version = "3.3.2"
val koin_android_version = "3.3.2"
val koin_android_compose_version = "3.4.1"
val koin_ktor = "3.3.0"

plugins {
    kotlin("jvm") version "1.8.0"
    id("io.ktor.plugin") version "2.2.1"
    kotlin("plugin.serialization") version "1.8.0"
}

group = "com.dennisdevelops"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()

}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jwt-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-sessions-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-jackson-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-config-yaml:$ktor_version")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

    // Koin for Ktor
    implementation ("io.insert-koin:koin-ktor:$koin_ktor")
// SLF4J Logger
    implementation ("io.insert-koin:koin-logger-slf4j:$koin_ktor")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}