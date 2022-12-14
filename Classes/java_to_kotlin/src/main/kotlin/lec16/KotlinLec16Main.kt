package lec16

fun JavaPerson.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}

fun Int.add(other: Int): Int {
    return this + other
}

// 중위 함수 키워드 infix
infix fun Int.add2(other: Int): Int {
    return this + other
}

fun main() {
    /**
     * 맴버 함수와 확장 함수가 동일하게 존재하는 경우, 맴버 함수가 우선적으로 동작
     */
    val person = JavaPerson("A", "B", 100)
    person.nextYearAge()

    /**
     * 상속의 경우 해당 변수의 현재 타입에 의해 어떤 확장 함수가 호출될지 결정
     */

    /**
     * 중위 함수는 '변수 함수이름 argument'의 구조
     * 변수와 argument가 하나씩만 있는 경우 사용 가능
     */
    3.add(4)
    3 add2 4
}
