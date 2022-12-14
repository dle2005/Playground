package lec14

/**
 * 상속은 가능하지만, 외부에서 클래스 상속 불가
 *
 * 컴파일 타임 때 하위 클래스의 타입을 모두 기억, 런타임에 추가 불가
 * 하위 클래스는 같은 패키지에 있어야 함
 *
 * Enum과 달리 상속 가능, 하위 클래스는 멀티 인스턴스가 가능
 *
 * 추상화가 필요한 Entity or DTO에 sealed class를 활용
 */
sealed class KotlinSealedClass(
    val name: String,
    val price: Long
)

class Avante : KotlinSealedClass("아반떼", 1000L)

class Sonata : KotlinSealedClass("소나타", 2000L)

class Grandeur : KotlinSealedClass("그랜져", 3000L)

private fun handleCar(car: KotlinSealedClass) {
    when (car) {
        is Sonata -> TODO()
        is Avante -> TODO()
        is Grandeur -> TODO()
    }
}