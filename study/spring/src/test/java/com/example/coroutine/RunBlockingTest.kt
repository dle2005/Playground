package com.example.coroutine


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class RunBlockingTest {

    /**
     * runBlocking 의 경우 스레드를 blocking 하기 때문에,
     * runBlockingTest 에서 runBlocking 을 호출하여 main 스레드를 blocking 하고
     * 내부에서 a, b, c 각각 main 스레드를 blocking 하여 동시에 실행이 불가
     */
    @Test
    fun runBlockingTest(): Unit = runBlocking {
        val time = measureTimeMillis {
            val a = runBlocking {
                println("val a = ${Thread.currentThread().name}")
                delay(3000)
                "a"
            }
            val b = runBlocking {
                println("val b = ${Thread.currentThread().name}")
                delay(2000)
                "b"
            }
            val c = runBlocking {
                println("val c = ${Thread.currentThread().name}")
                delay(1000)
                "c"
            }
        }

        println("Total time = ${time}ms")
        Assertions.assertThat(time).isGreaterThan(6000)
    }

    /**
     * 내부 runBlocking 에서 다른 스레드를 지정하더라도,
     * runBlocking 안의 동작을 해당 스레드로 하는거지,
     * 현재 스레드는 blocking 상태
     */
    @Test
    fun runBlockingTest2(): Unit = runBlocking {
        val time = measureTimeMillis {
            println("main = ${Thread.currentThread().name}")

            val a = runBlocking {
                println("val a = ${Thread.currentThread().name}")
                delay(3000)
                "a"
            }
            val b = runBlocking(Dispatchers.IO) {
                println("val b = ${Thread.currentThread().name}")
                delay(2000)
                "b"
            }
            val c = runBlocking(Dispatchers.Default) {
                println("val c = ${Thread.currentThread().name}")
                delay(1000)
                "c"
            }
        }

        println("Total time = ${time}ms")
        Assertions.assertThat(time).isGreaterThan(6000)
    }
}
