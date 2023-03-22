package chapter2

/**
 * 자바에 널 허용성 지시자 추가하기
 *
 * 문제
 * 코틀린 코드가 자바 코드와 상호작용이 필요하고 널 허용성(nullability) 애노테이션을 강제하고 싶다.
 *
 * 해법
 * 코틀 코드에 JSR-305 널 허용성 애노테이션을 강제하려면 컴파일 타임 파라미터 Xjsr305=strict를 사용한다
 *
 * 설명
 * 코틀린의 주요 기능 중 하나는 컴파일 시간에 타입 시스템에 널 허용성을 강제하는 것이다.
 * String 타입으로 변수를 정의하면 해당 변수는 절대 널이 될 수 없다.
 * 반면에 String? 타입으로 정의하면 해당 변수는 널이 될 수 있다.
 */

fun main() {
    // 2-8. 널 허용 타입과 널 비허용 타입
    var s: String = "Hello, World" // 널이 될 수 없거나 컴파일되지 않는다.
    var t: String? = null // 타입에 있는 물음표는 널 허용 타입을 나타낸다.

    /**
     * 이 코드는 널 허용성 매커니즘이 없는 자바 코드와 상호작용하기 전까지는 잘 동작한다.
     * 자바는 javax.annotation 패키지에 @Nonnull 애노테이션이 정의되어 있지만 이 사양은 개발이 중단된 상태다.
     * 하지만 많은 라이브러리가 JSR-305 호환 애노테이션을 사용 중이며 코틀린은 해당 호환 라이브러리를 지원한다.
     *
     * 스프링 프레임워크를 사용할 때 빌드 파일에 아래의 코드를 추가함으로써 호환성을 강제할 수 있다.
     *
     * compileKotlin {
     *      kotlinOptions {
     *          jvmTarget = "1.8"
     *          freeCompilerArgs = ["-Xjsr305=strict"]
     *      }
     * }
     *
     * compileTestKotlin {
     *      kotlinOptions {
     *          jvmTarget = "1.8"
     *          freeCompilerArgs = ["-Xjsr305=strict"]
     *      }
     * }
     */


}