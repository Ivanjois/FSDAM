plugins {
    kotlin("jvm") version "2.4.10"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.github.doyaaaaaken:kotlin-csv-jvm:1.9.1")
}

kotlin {
    jvmToolchain(24)
}

application {
    mainClass.set("org.example.MainKt")
}

tasks.test {
    useJUnitPlatform()
}
