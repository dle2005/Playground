import kotlinx.coroutines.*

/**
 * DefaultDispatcher = Dispatchers.Default
 * CPU 바운드 작업을 위해서 프레임워크에 의해 자동으로 생성되는 스레드 풀
 * 스레드 풀의 최대 크기는 시스템의 코어 수에서 1을 뺸 값
 */

/**
 * Unconfined
 * 첫 번째 중단 지점에 도달할 때까지 현재 스레드에 있는 코루틴을 실행
 * 일시 중지된 후에, 일시 중단 연산에서 사용된 기존 스레드에서 다시 시작
 *
 * Starting in main
 * Resuming in kotlinx.coroutines.DefaultExecutor
 */
fun unconfined() = runBlocking {
    GlobalScope.launch(Dispatchers.Unconfined) {
        println("Starting in ${Thread.currentThread().name}")
        delay(500)
        println("Resuming in ${Thread.currentThread().name}")
    }.join()
}

/**
 * 단일 스레드 컨텍스트
 * 항상 코루틴이 특정 스레드 안에서 실행된다는 것을 보장
 *
 * Starting in myThread
 * Resuming in myThread
 */
fun singleThreadContext() = runBlocking {
    val dispatcher = newSingleThreadContext("myThread")

    GlobalScope.launch(dispatcher) {
        println("Starting in ${Thread.currentThread().name}")
        delay(500)
        println("Resuming in ${Thread.currentThread().name}")
    }.join()
}

/**
 * 스레드 폴
 * 해당 폴에서 가용한 스레드에서 코루틴을 시작하고 재개
 * 가용한 스레드를 정하고 부하 분산을 위한 방법도 정하기 떄문에 따로 할 작업은 없음
 *
 * Starting in myPool-1
 * Resuming in myPool-2
 */
fun threadPool() = runBlocking {
    val dispatcher = newFixedThreadPoolContext(4, "myPool")

    GlobalScope.launch(dispatcher) {
        println("Starting in ${Thread.currentThread().name}")
        delay(500)
        println("Resuming in ${Thread.currentThread().name}")
    }.join()
}

/**
 * 컨텍스트 조합
 */
fun contextCombine() = runBlocking {
    val dispatcher = newSingleThreadContext("myDispatcher")
    val handler = CoroutineExceptionHandler { _, throwable ->
        println("Error captured")
        println("Message: ${throwable.message}")
    }

    GlobalScope.launch(dispatcher + handler) {
        println("Running in ${Thread.currentThread().name}")
        TODO("Not implemented!")
    }.join()
}

fun main() {
//    unconfined()
//    singleThreadContext()
//    threadPool()
    contextCombine()
}