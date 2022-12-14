package lec10

interface KotlinFlyable {

    // default 키워드 없이 메소드 구현이 가능
    fun act() {
        println("파닥 파닥")
    }

    // 코틀린 추상 메소드
    fun fly()
}