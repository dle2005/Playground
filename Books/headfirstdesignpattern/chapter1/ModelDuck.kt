package headfirstdesignpattern.chapter1

class ModelDuck(
    private val flyBehavior: FlyBehavior = FlyNoWay(),
    private val quackBehavior: QuackBehavior = Quack()
) : Duck(
    flyBehavior = flyBehavior,
    quackBehavior = quackBehavior
) {
    override fun display() {
        println("저는 모형 오리입니다.")
    }
}