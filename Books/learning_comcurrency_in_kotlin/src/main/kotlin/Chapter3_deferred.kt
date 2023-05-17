import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * deffered: 결과를 반환하는 비동기 함수
 */

/**
 * 디퍼드는 예외 전파하지 않음
 */
fun deffered() = runBlocking {
    val deffered = GlobalScope.async {
        TODO("Not implemented")
    }

    delay(2000)
}

fun exceptionSpread(): Nothing = runBlocking {
    val deffered = GlobalScope.async {
        TODO("Not implemented")
    }

    delay(2000)
    deffered.await()
}

/**
 * Deffered cancelled due to An operation is not implemented: Not implemented yesy
 * Total time = 2055ms
 */
fun exceptionHandling() = runBlocking {
    val deffered = GlobalScope.async {
        TODO("Not implemented")
    }

    delay(2000)

    try {
        deffered.await()
    } catch (throwable: Throwable) {
        println("Deffered cancelled due to ${throwable.message}")
    }
}

/**
 * await() 대신 join()을 사용해 디퍼드를 기다리면 예외 전파되지 않음
 * 요청을 읽을 때 예외를 전파
 */
fun notSpreadException() = runBlocking {
    val deffered = GlobalScope.async {
        TODO("Not implemented")
    }

    delay(2000)

    deffered.join()
}

fun spreadException(): Nothing = runBlocking {
    val deffered = GlobalScope.async {
        TODO("Not implemented")
    }

    delay(2000)

    deffered.join()

    deffered.getCompleted()
}

fun main() {
    val time = measureTimeMillis {
//        deffered()
//        exceptionSpread()
//        exceptionHandling()
//        notSpreadException()
        spreadException()
    }
    println("Total time = ${time}ms")
}