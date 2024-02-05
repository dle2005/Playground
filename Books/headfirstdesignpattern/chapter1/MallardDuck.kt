package headfirstdesignpattern.chapter1

class MallardDuck(
    flyBehavior: FlyBehavior = FlyWithWings(),
    quackBehavior: QuackBehavior = Quack()
) : Duck(
    flyBehavior = flyBehavior,
    quackBehavior = quackBehavior
) {

    override fun display() {
        println("저는 몰오리입니다.")
    }
}