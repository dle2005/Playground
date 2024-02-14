package domaindrivendevelopment.chapter1.vo

data class Money(
    val value: Int
) {
    fun add(money: Money) = Money(this.value + money.value)

    fun multiply(multiplier: Int) = Money(this.value * multiplier)
}