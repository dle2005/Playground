package com.example.spring.coroutine

import kotlin.system.measureTimeMillis
import kotlinx.coroutines.*

fun main() {
    val time = measureTimeMillis {
        callRoutinesAsync()
    }
    println("Total time = ${time}ms")
}

fun callRoutinesLaunch() = runBlocking {
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

fun callRoutinesAsync() = runBlocking {
    val routine1 = async { routine1() }
    val routine2 = async { routine2() }
    val routine3 = async { routine3() }

    routine1.await()
    routine2.await()
    routine3.await()
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