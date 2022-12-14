package lec09

fun main() {
    val kotlinPerson = KotlinPerson("이동곤", 27)

    // '.'필드를 통해 바로 getter와 setter를 가져올 수 있음
    println(kotlinPerson.name)
    kotlinPerson.age = 28

    val javaPerson = JavaPerson("이동곤", 27)

    // Java Class에서도 '.'필드를 통해 바로 getter와 setter를 가져올 수 있음
    println(javaPerson.name)
    javaPerson.age = 28

    // val person = KotlinPerson("이동곤")
}

/** class KotlinPerson (val name: String, age: Int)
 * 코틀린에서는 생성자를 만들어 줄 때 동시에 필드(프로퍼티)를 선언할 수 있음
 * 주 생성자(primary constructor)는 파라미터가 하나라도 있다면, 반드시 존재해야 함
 */
class KotlinPerson (
    /**
     * 부 생성자의 사용보다 default parameter 사용을 권장
     * 만약 사용해야 한다면, 그보단 정적 팩토리 메소드 사용을 권장
     */
    name: String = "이동곤",
    var age: Int = 1
){

    /**
     * 클래스가 초기화되는 시점에 init 블록이 한 번 호출
     */
    init {
        // 검증은 클래스 생성 시점에 해줌
        if (age <= 0) {
            throw java.lang.IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }

        // 호출은 역순으로 실행, 초기화 블록 -> 첫 번째 부 생성자 -> 두 번째 부 생성자
        println("초기화 블록")
    }

    /**
     * 기본이 되는 주 생성자(primary constructor)는 가장 윗 부분에 생성
     * 부 생성자(secondary constructor)는 클래스 블록 안에 constructor 키워드와 함께 생성
     * 최종적으로 주 생성자를 this로 호출해야 함, body를 가질 수 있음
     */
    constructor(name: String) : this(name, 1) {
        println("첫 번째 부 생성자")
    }

    constructor() : this("이동곤") {
        println("두 번째 부 생성자")
    }

    /**
     * custom getter, 클래스에 프로퍼티가 있는 것처럼 보여줌
     * fun isAdult(): Boolean {
            return this.age >= 20
        }
     */
    val isAdult: Boolean
        get() = this.age >= 20


    /**
     * 생성자에 val 변수 선언 시, 하나의 프로퍼티이므로 getter가 자동 생성
     * custom getter 생성을 위해선 val 키워드를 제거
     *
     * name 대신에 field 키워드를 사용, 자기 자신을 가르키는 예약어(backing filed)
     * name 자체로도 getter가 되어 무한루프가 발생
     */
    var name = name
        get() = field.uppercase()
        set(value) {
            field = value.uppercase()
        }

    /**
     * 생성자에 val 변수 선언하고, 함수로 사용할 수 있음
     * 실제 backing filed를 사용하여 custom getter를 만들기 보다 아래 방법을 선호
     *
     * fun getUppercaseName() = this.name.uppercase()
     *
     * val uppercaseName: String
     *     get() = this.name.uppercase()
     */
}