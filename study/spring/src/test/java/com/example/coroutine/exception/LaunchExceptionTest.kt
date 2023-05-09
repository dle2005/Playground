package com.example.coroutine.exception

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class LaunchExceptionTest {

    @Test
    fun launchExceptionTest() {
        runBlocking {
            testFun()
        }
    }

    /**
     * a run, b run 두 에러 메시지 모두 출력됨
     * 각각의 스코프에 대해서 예외 처리가 가능
     */
    private suspend fun testFun() {
        withContext(exceptionHandler) {
            launch(SupervisorJob()) {
                throw RuntimeException("a run")
            }
            println("a end")

            launch(SupervisorJob()) {
                throw RuntimeException("b run")
            }
            println("b end")
        }
    }
}

private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    println(throwable.message)
}
