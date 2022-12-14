package lec12

class KotlinPerson private constructor(
    var name: String,
    var age: Int
){
    /**
     * kotlin 에서는 static 키워드가 존재하지 않음
     * static 대신에 companion object(동행 객체)를 사용
     *
     * 동반 객체도 하나의 객체로 간주
     * 이름을 붙일 수 있으며, interface 구현할 수 있음
     */
    companion object Factory : Log{
        // const 붙이면 컴파일 시에 변수 할당
        private const val MIN_AGE = 1

        @JvmStatic
        fun newBaby(name: String): KotlinPerson {
            return KotlinPerson(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Person 클래스의 동행 객체 Factory 입니다.")
        }
    }
}