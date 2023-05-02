import kotlinx.coroutines.*
import java.util.ArrayList
import kotlin.system.measureTimeMillis

suspend fun createCoroutines(amount: Int) = runBlocking {
    val jobs = ArrayList<Job>()

    for (i in 1..amount) {
        jobs += launch {
            println("Started $i in ${Thread.currentThread().name}")
            delay(1000)
            println("Finished $i in ${Thread.currentThread().name}")
        }
    }

    jobs.forEach {
        it.join()
    }
}

suspend fun getName(): String {
    delay(1000)
    return "Susan"
}

suspend fun getLastName(): String {
    delay(1000)
    return "Calvin"
}

fun main() = runBlocking {
    println("${Thread.activeCount()} threads active at the start")

    val time = measureTimeMillis {
        createCoroutines(3)
    }

    println("${Thread.activeCount()} threads active at the end")
    println("Took $time ms")

    val time2 = measureTimeMillis {
        val name = async { getName() }
        val lastName = async { getLastName() }

        println("Hello, ${name.await()} ${lastName.await()}")
    }

    println("Execution took $time2 ms")
}