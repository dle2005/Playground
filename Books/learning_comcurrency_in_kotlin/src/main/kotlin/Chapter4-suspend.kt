import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * 일시 중단 함수를 만들려면 suspend 제어자만 추가하면 된다
 * 일시 중단 함수는 delay()와 같은 다른 일시 중단 함수를 직접 호출할 수 있음
 * 코드를 코루틴 빌더 안에 감쌀 필요가 없음
 */
suspend fun greetDelayed(delayMills: Long) {
    delay(delayMills)
    println("Hello World")
}

/**
 * 일시 중단 연산은 다른 일시 중단 연산에서만 호출될 수 있음
 * 비 일시 중단 코드에서 함수를 호출하려면 코루틴 빌더로 감싸야 한다
 */
fun main() {
    runBlocking {
        greetDelayed(1000)
    }
}