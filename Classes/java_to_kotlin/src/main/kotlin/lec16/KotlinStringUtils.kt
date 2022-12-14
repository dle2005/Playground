package lec16

fun main() {
    val str: String = "ABC"
    println(str.lastChar())
}

/**
 * fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {
 *     this를 이용해 실제 클래스 안의 값에 접근
 * }
 *
 * 원래 String에 있는 맴버함수 처럼 사용할 수 있음.
 *
 * 확장함수는 클래스에 있는 private 또는 protected 맴버를 가져올 수 없음
 */
fun String.lastChar(): Char {
    return this[this.length - 1]
}