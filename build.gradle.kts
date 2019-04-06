import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
}

group = "com.github.tonybaines"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile("org.apache.kafka:kafka-clients:2.0.0" )
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}