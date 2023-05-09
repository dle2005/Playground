package com.example.coroutine.exception

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class AsyncExceptionTest {

    @Test
    fun asyncExceptionTest() {
        runBlocking {
            testFun()
        }
    }


    /**
     * exceptionHandler 를 통한 예외처리가 불가능
     * await 하는 시점까지 에러 발생하지 않음.
     */
    private suspend fun testFun() {
        coroutineScope {
            val a = async(SupervisorJob()) {
                throw RuntimeException("a run")
            }
            println("a end")

            val b = async(SupervisorJob()) {
                throw RuntimeException("b run")
            }
            println("b end")

            try {
                a.await()
            } catch (e: RuntimeException) {
                println(e.message)
            }

            try {
                b.await()
            } catch (e: RuntimeException) {
                println(e.message)
            }
        }
    }
}
