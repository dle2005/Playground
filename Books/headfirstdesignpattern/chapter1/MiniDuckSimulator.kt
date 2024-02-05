package headfirstdesignpattern.chapter1

fun main() {
    MallardDuck().run {
        this.performQuack()
        this.performFly()
    }

    ModelDuck().run {
        this.performFly()
        this.setFlyBehavior(FlyRocketPowered())
        this.performFly()
    }
}