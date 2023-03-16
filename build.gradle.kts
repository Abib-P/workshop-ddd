plugins {
    kotlin("jvm") version "1.8.10"
    application
}

group = "com.esgi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //junit
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}
