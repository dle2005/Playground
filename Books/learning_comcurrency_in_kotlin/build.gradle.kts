import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java

    // kotlin plugins
    kotlin("jvm") version "1.8.20-RC2"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    // kotlin
    implementation(kotlin("stdlib-jdk8"))

    // coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:1.6.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "11"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
}