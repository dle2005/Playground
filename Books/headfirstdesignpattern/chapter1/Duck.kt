package headfirstdesignpattern.chapter1

abstract class Duck(
    private var flyBehavior: FlyBehavior,
    private var quackBehavior: QuackBehavior,
) {
    abstract fun display()

    /**
     * 행동 클래스에 위임
     */
    fun performFly() = flyBehavior.fly()

    /**
     * 꽥꽬거리는 행동을 직접처리하는 대신
     * quackBehavior 로 참조되는 객체에 그 행동을 위임
     */
    fun performQuack() = quackBehavior.quack()

    fun setFlyBehavior(flyBehavior: FlyBehavior) {
        this.flyBehavior = flyBehavior
    }

    fun setQuackBehavior(quackBehavior: QuackBehavior) {
        this.quackBehavior = quackBehavior
    }
}