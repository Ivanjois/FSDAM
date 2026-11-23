plugins {
    kotlin("jvm") version "2.4.20"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Dependencia anterior de SQLite (conservada comentada como referencia de la migración)
    // implementation("org.xerial:sqlite-jdbc:3.47.2.0")
    implementation("org.postgresql:postgresql:42.7.4")
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(24)
}

tasks.test {
    useJUnitPlatform()
}
tasks.withType<JavaExec> {
    jvmArgs("--enable-native-access=ALL-UNNAMED")
    standardInput = System.`in`
}