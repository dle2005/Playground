package lec10

/**
 * 인터페이스 상속 시에도 : 을 사용
 */
class KotlinPenguin(
    species: String
) : KotlinAnimal(species, 2), KotlinSwimable, KotlinFlyable{

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직인다~ 꿱꿱")
    }

    // 프로퍼티를 override 할 때 무조건 Open을 붙여 줘야 함
    override val legCount: Int
        get() = super.legCount + this.wingCount

    override val swimAbility: Int
        get() = 3

    /**
     * 인터페이스의 함수를 override 할 때 super<interface 이름>.함수
     */
    override fun act() {
        super<KotlinSwimable>.act()
        super<KotlinFlyable>.act()
    }

    override fun fly() {

    }

}