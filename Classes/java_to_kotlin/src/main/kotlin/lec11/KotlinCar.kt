package lec11

class KotlinCar(
    internal val name: String,
    private val owner: String,
    _price: Int
) {
    // setter에만 추가로 가시성 부여
    var price = _price
        private set
}