import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"

    // kotlin plugins
    val kotlinVersion = "1.8.0"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("plugin.noarg") version kotlinVersion
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    // spring-web
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    // kotlin
    implementation(kotlin("stdlib-jdk8"))

    // feign
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.0.1")

    // coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j") // coroutine log
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor") // combine webflux


    // webflux
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation("org.springframework:spring-context")

    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // h2 db
    runtimeOnly("com.h2database:h2")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
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