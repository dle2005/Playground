package lec10

interface KotlinSwimable {

    /**
     * field가 아니라 getter에 대한 것을 아래에 구현하길 기대
     */
    val swimAbility: Int
        get() = 3   // default value

    // default 키워드 없이 메소드 구현이 가능
    fun act() {
        println("어푸 어푸")
    }
}