package chapter2

import java.text.NumberFormat

/**
 * 자바를 위한 메소드 중복
 *
 * 문제
 * 기본 파라미터를 가진 코틀린 함수가 있는데,
 * 자바에서 각 파라미터의 값을 직접적으로 명시하지 않고 해당 코틀린 함수를 호출하고 싶다.
 *
 * 해법
 * @JvmOverloads 애노테이션을 해당 함수에 추가한다.
 */

// 2-12. 기본 파라미터가 정의된 코틀린 함수
@JvmOverloads
fun addProduct(name: String, price: Double = 0.0, desc: String? = null) =
    "Adding product with $name, ${desc ?: "None"}, and " +
            NumberFormat.getCurrencyInstance().format(price)
// addProduct 함수는 문자열 name이 필수지만 description과 price는 기본값이 있다.
// description에 널을 할당할 수 있고 기본값도 널인 반면 price의 기본값은 0이다.

/**
 * Optional 이나 널 허용 속성은 함수 시그니처의 마지막에 위치시켜야 한다.
 * 그렇게 해야만 해당 인자를 사용해서 함수를 호출할 때 Optional 또는 널 허용 속성을 생략할 수 있다.
 */
