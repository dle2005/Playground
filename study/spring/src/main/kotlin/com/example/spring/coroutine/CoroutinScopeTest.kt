package com.example.spring.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun main() {
    val runBlockingTime = measureTimeMillis {
        launchScope()
        coroutineScope {
            coroutineScopeLaunch()
        }
    }
    println("Total time = ${runBlockingTime}ms")

    val coroutineScopeTime = measureTimeMillis {
        coroutineScope {
            coroutineScopeLaunch()
        }
    }
    println("Total time = ${coroutineScopeTime}ms")
}

fun launchScope() = runBlocking {
    launch {
        insideLaunch()
        coroutineScopeLaunch()
    }
}

suspend fun coroutineScopeLaunch() {
    coroutineScope {
        launch {
            insideCoroutineScope()
        }
    }
}

suspend fun insideLaunch() {
    println("insideLaunch thread begin = ${Thread.currentThread().name}")
    println("Inside launch")
    delay(1000)
    println("Done launch")
    println("insideLaunch thread end = ${Thread.currentThread().name}")
}

suspend fun insideCoroutineScope() {
    println("insideCoroutineScope thread begin = ${Thread.currentThread().name}")
    println("Inside coroutineScope")
    delay(2000)
    println("Done coroutineScope")
    println("insideCoroutineScope thread end = ${Thread.currentThread().name}")
}