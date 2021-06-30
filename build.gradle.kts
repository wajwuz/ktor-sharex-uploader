plugins {
    kotlin("jvm") version "1.5.20"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    application
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
    mainClass.set("io.ktor.server.netty.EngineMain")
}

group = "net.michal"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-server-netty:1.6.0")
    implementation("io.ktor:ktor-html-builder:1.6.0")
    implementation("org.apache.commons:commons-lang3:3.9")
}
