package com.example.spring.coroutine

import kotlin.system.measureTimeMillis
import kotlinx.coroutines.*

fun main() = runBlocking {
    val time = measureTimeMillis {
        callRoutines()
    }
    println("Total time = ${time}ms")
}

fun callRoutines() = runBlocking {
    launch {
        routine1()
    }
    launch {
        routine2()
    }
    launch {
        routine3()
    }
}


suspend fun routine1() {
    println("routine1 thread = ${Thread.currentThread().name}")
    delay(3000)
    println("routine1 thread = ${Thread.currentThread().name}")
}

suspend fun routine2() {
    println("routine2 thread = ${Thread.currentThread().name}")
    delay(2000)
    println("routine2 thread = ${Thread.currentThread().name}")
}

suspend fun routine3() {
    println("routine3 thread = ${Thread.currentThread().name}")
    delay(1000)
    println("routine3 thread = ${Thread.currentThread().name}")
}