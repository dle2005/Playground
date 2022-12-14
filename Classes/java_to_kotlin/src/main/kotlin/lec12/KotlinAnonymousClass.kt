package lec12

fun main() {
    /**
     * new 키워드 대신 object 키워드를 사용
     * Movable을 상속받은 objcet를 만든다는 의미
     */
    moveSomething(object : Movable{
        override fun move() {
            println("무브")
        }

        override fun fly() {
            println("날다")
        }
    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}