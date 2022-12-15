package lec17

/**
 * 코틀린에서는 함수가 그 자체로 값이 될 수 있음
 * 변수에 할당할수도, 파라미터로 넘길 수도 있음
 */

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )

    // fun 뒤에 함수 이름이 없음
    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    val isApple2: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    val isApple3 = { fruit: Fruit -> fruit.name == "사과"}

    val isApple4: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과"}

    isApple(Fruit("사과", 1000))
    isApple.invoke(Fruit("사과", 1000))

    filterFruits(fruits, isApple)
    filterFruits(fruits, fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    })
    // 마지막 파라미터로 함수인 경우 소괄호 밖에 람다 사용 가능
    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }
    // 파라미터가 한 개인 경우에는 it 으로 직접 참조해 사용 가능
    filterFruits(fruits) { it.name == "사과" }
    /// return 생략해도, 마지막 줄의 결과가 람다의 반환값
    filterFruits(fruits) {fruit ->
        println("")
        fruit.name == "사과"
    }

    /**
     * 자바에서는 람다 사용 시에 final 혹은 실질적으로 final인 변수만 사용 가능
     * 코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 정보를 가지고 있음
     * 이 데이터 구조를 Closure라고 부른다
     */
    var targetFruitName = "바나나"
    targetFruitName = "수박"
    filterFruits(fruits) { it.name == targetFruitName }

}

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}