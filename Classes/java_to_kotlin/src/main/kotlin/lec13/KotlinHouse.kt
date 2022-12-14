package lec13

class KotlinHouse(
    private val address: String,
    private val livingRomm: LivingRoom = LivingRoom(10.0)
) {

    /**
     * 코틀린에서는 기본적으로 바깥 클래스에 대한 연결이 없는 중첩 클래스가 만들어짐
     *
     * inner 를 붙이면 바깥 클래스를 참조하는 잘못된 이너 클래스 생성이 가능
     * 바깥 클래스를 참조하기 위해서는 'this@바깥 클래스'를 사용
     */
    class LivingRoom(
        private val area: Double
    )
}