package chapter2

/**
 * 명시적으로 타입 변환하기
 *
 * 문제
 * 코틀린은 자동으로 기본타입을 더 넓은 타입으로 승격하지 않는다
 *
 * 해결
 * 더 작은 타입을 명시적으로 변환하려면 toInt, toLong 등 구체적인 변환 함수를 사용한다.
 */

fun main() {
    // 2-22. 자바에서 더 짧은 기본 타입을 더 긴 기본 타입으로 승격시키기
    /**
     * int myInt = 3;
     * long myLong = myInt; int 가 long 으로 자동 승격
     */

    // 2-24. 코틀린에서 int 를 long 으로 승격시키기
    val intVar: Int = 3
    // val longVar: Long = intVar 컴파일되지 않음
    val longVar: Long = intVar.toLong() // 명시적 타입 변환

    // 타입 변환을 투명하게 수행하는 연산자 중복 장점이 있기 때문에
    // 다음 코드는 명시적 타입 변환이 필요하지 않다.
    val longSum: Long = 3L + intVar
    // 더하기 연산자는 자동으로 intVar 의 값을 long 으로 변환하고 long 리터럴에 그 값을 더한다.
}