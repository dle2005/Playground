package lec10

abstract class KotlinAnimal(
    protected val species: String,
    // 프로퍼티를 override 할 때 무조건 Open을 붙여 줘야 함
    protected open val legCount: Int
) {

    abstract fun move()

}