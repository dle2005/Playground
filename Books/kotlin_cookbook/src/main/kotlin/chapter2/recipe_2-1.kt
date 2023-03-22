package chapter2

/**
 * 코틀린에서 널 허용 타입 사용하기
 *
 * 문제
 * 변수가 절대 null 값을 갖지 못하게 하고 싶다.
 *
 * 해법
 * 물음표를 사용하지 않고 변수의 타입을 정의한다.
 * 또한 널 허용 타입은 안전 호출 연산자(?,)나 엘비스(Elvis) 연사자(?:)와 결합해서 사용한다.
 *
 * 설명
 * 코틀린의 가장 매력적인 기능은 가능한 모든 널 값을 제거하는다는 것이다.
 * 변수 타입에 뒤따라오는 물음표 없이 변수를 정의하면 코틀린 컴파일러는 해당 변수에 널이 아닌 값을 요구한다.
 */

fun main() {
    // 2-1. 널 할당이 불가능한 변수 선업
    var name: String

    name = "Dolly" // 널이 아닌 문자열을 할당
    // name = null  // 널을 할당하면 컴파일되지 않음

    // 2-2. 널 허용 변수 선언
    class Person(val first: String,
                 val middle: String?,
                 val last: String)

    // 널 값일지라도 중간 이름인 middle 파라미터에 값을 제공해야 한다.
    val jdkRowling = Person("Joanne", null, "Rowling")
    val northWest = Person("North", null, "West")

    // 2-3. val 변수의 널 허용성 검사하기
    val valP = Person(first = "North", middle = null, last = "West")

    if (valP.middle != null) {
        // 널 할당이 불가능한 문자열 타입으로 smart cast 을 수행
        val middleNameLength = valP.middle.length
    }
    // if 문은 middle 속성이 널이 아닌 값을 가지고 있는지 확인하고, middle 값이 널이 아니라면 마치
    // p.middle의 타입을 String? 타입 대신 String 타입으로 처리하는 smart cast 을 수행한다.
    // smart cast 을 수행할 수 있는 것은 변수 p가 한번 설정되면 그 값을 바꿀 수 없는 val 키워드로 선언되었기 때문이다.

    // 2-4. var 변수가 널 값이 아님을 단언하기
    var varP = Person(first = "North", middle = null, last = "West")

    if (varP != null) {
        // 널이 아님을 단언(assert)(꼭 필요한 경우가 아니라면 사용하지 말 것)
        val middleNameLength = varP.middle!!.length
    }

    // 2-5. 안전 호출 연산자 사용하기
    var p = Person(first = "North", middle = null, last = "West")
    var middleNameLength = p.middle?.length
    // 안전 호출. 결과 타입은 Int?, 결과 추론 타입도 널 허용 타입이라는 문제가 있음
    // 2-6처럼 안전 호출 연산자와 엘비스 연산자(?:)를 병행해서 사용하는 것이 유용하다.

    // 2-6. 안전 호출 연산자와 엘비스 연산자
    p = Person(first = "North", middle = null, last = "West")
    middleNameLength = p.middle?.length ?: 0
    // 엘비스 연산자는 자신의 왼쪽에 위치한 식의 값을 확인해서 해당 값이 널이 아니면 그 값을 리턴한다.
    // 만약 왼쪽의 값이 널이면 오른쪽에 위치한 값을 돌려준다.
    // 오른쪽은 식이므로 함수의 인자를 확인할 때 return 이나 throw 를 사용할 수 있다

    // 2-7. 안전 타입 변환 연산자
    val p1 = p as? Person
    // 타입 변환에서 발생하는 ClassCastException 발생하는 상황을 방지
    // 변환에 실패하면 그 결과 p1 이 널 값을 받는다
}