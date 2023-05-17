import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

/**
 * job: 결과가 없는 비동기 함수
 */

/**
 * 잡 내부에서 발생하는 예외는 잡을 생성한 곳까지 전파
 * 투두로 남겨 NotImplementedError 발생
 */
fun 장애_전파(): Unit = runBlocking {
    GlobalScope.launch {
        TODO("Not Implemented")
    }

    delay(500)
}

/**
 * Job()을 사용해 생성될 때 자동으로 시작
 * 잡을 생성할 때 자동으로 시작되지 않게 하려면 LAZY를 사용
 * 오류가 출력되지 않음. 작업이 생성됐지만, 시작된 적이 없음
 */
fun 실행_지연(): Unit = runBlocking {
    GlobalScope.launch(start = CoroutineStart.LAZY) {
        TODO("Not Implemented")
    }

    delay(500)
}

/**
 * job.start()가 호출될 때 실행을 일시 중단하지 않음
 * 애플리케이션이 job이 완료되는 것을 기다리지 않고 실행을 끝냄
 * 출력: outside job, Total time = 58ms
 */
fun job_start(): Unit = runBlocking {
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delay(3000)
        println("inside job")
    }

    println("outside job")
    job.start()
}

/**
 * join()을 사용하면 애플리케이션이 job을 완료할 때까지 대기
 * job()은 실행을 일시 중단할 수 있으므로 코루틴 또는 일시 중단 함수에서 호출되어야 함
 * 이를 위해 runBlocking()이 사용되고 있음
 * 출력: outside job, inside job, Total time = 3056ms
 */
fun job_join(): Unit = runBlocking {
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delay(3000)
        println("inside job")
    }

    println("outside job")
    job.join()
}

/**
 * 취소 요청을 받은 활성 잡은 취소 중이라고하는 스테이징 상태로 들어갈 수 있음
 * 출력: outside job, Total time = 40ms
 */
@OptIn(InternalCoroutinesApi::class)
fun job_cancel(): Unit = runBlocking {
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delay(3000)
        println("inside job")
    }

    println("outside job")
    job.cancel(cause = CancellationException("Timeout!"))

    val cancellation = job.getCancellationException()
    println(cancellation)
}

/**
 * 에러 출력이후 나머지 동작 실행
 * 출력: Job cancelled due to An operation is not implemented: Not Implemented
 * Total time = 2049ms
 */
fun exceptionHandlder(): Unit = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler {
        _: CoroutineContext, throwable: Throwable ->
        println("Job cancelled due to ${throwable.message}")
    }

    GlobalScope.launch(exceptionHandler) {
        TODO("Not Implemented")
    }

    delay(2000)
}

/**
 * 코드를 그대로 따라 했지만 handling 되지 않음
 */
fun invokeOnCompletion() = runBlocking<Unit> {
    GlobalScope.launch {
        TODO("Not Implemented")
    }.invokeOnCompletion {cause ->
        cause?.let {
            println("Job cancelled due to ${it.message}")
        }
    }
}

/**
 * 최초 join을 통해 job이 완료될 때까지 대기
 * 1초 후 start를 통해 재시작, 이후 join을 통해 완료 대기
 * Total time = 4050ms
 */
fun restartJob() = runBlocking {
    val job = GlobalScope.launch {
        delay(2000)
    }

    // wait for it to complete once
    job.join()

    delay(1000)

    job.start()
    job.join()
}

fun main() {
    val time = measureTimeMillis {
//        장애_전파()
//        실행_지연()
//        job_start()
//        job_join()
//        job_cancel()
//        exceptionHandlder()
//        invokeOnCompletion()
        restartJob()
    }
    println("Total time = ${time}ms")
}